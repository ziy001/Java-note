import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/7/18
 * TODO:自定义加载器
 */
public class CustomLoader extends ClassLoader {

    /**
     * 使用该返回查找类并返回Class对象
     * @param name 全限定Class名
     * @return 返回指定类的Class对象
     * @throws ClassNotFoundException 当找不到Class时抛出该异常
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //对name进行处理
        String[] reName = name.split("\\\\");
        String javaName = reName[reName.length - 1]+ ".java";
        String className = reName[reName.length - 1]+ ".class";
        System.out.println(javaName+ "   "+ className);
        File javaFile = new File(name+".java");
        File classFile = new File(name+".class");
        //检查Class文件
        if(!classFile.exists() || classFile.lastModified() < javaFile.lastModified()) {
            //对java源文件进行编译
            if(!javaFile.exists()) {
                throw new ClassNotFoundException("源文件不存在");
            }
            //class文件重新编译
            compile(javaName);
        }
        //转换为二进制流
        ByteBuffer bytes = getBytes(classFile);
        //加载
        final Class<?> cls = defineClass(className, bytes, null);
        if(cls == null) {
            throw new ClassNotFoundException(className +"加载失败");
        }
        return cls;
    }
    //获取class文件的二进制流
    private ByteBuffer getBytes(File classFile)
            throws ClassNotFoundException {
        ByteBuffer buff = ByteBuffer.allocate((int) classFile.length());
        try(FileChannel channel = new FileInputStream(classFile).getChannel()) {
            channel.read(buff);
            buff.flip();
        } catch (Throwable e) {
            throw new ClassNotFoundException("加载失败");
        }
        return buff;
    }
    //使用javac编译
    private void compile(String javaName)
            throws ClassNotFoundException {
        try {
            String com1 = "cd C:\\Users\\vi193\\Desktop";
            String com2 = "javac " + javaName;
            Process process = Runtime.getRuntime().exec(new String[]{com1, com2});
            process.waitFor(1024, TimeUnit.SECONDS);
            if(process.exitValue() != 0) {
                throw new IOException();
            }
        } catch (IOException | InterruptedException e) {
            throw new ClassNotFoundException("加载失败");
        }
    }
    public static void main(String[] args)
            throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        CustomLoader loader = new CustomLoader();
        Class<?> aClass = loader.loadClass("C:\\Users\\vi193\\Desktop\\MainTest");
        Method main = aClass.getMethod("main", new String[0].getClass());
        main.invoke(null, "");

    }
}
