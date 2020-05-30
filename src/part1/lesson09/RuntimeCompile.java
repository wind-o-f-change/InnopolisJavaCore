package part1.lesson09;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

/**
 * Create 30.05.2020
 *
 * @autor Evtushenko Anton
 */

public class RuntimeCompile {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        StringBuilder source = new StringBuilder(64);
        source.append("package OOP;\n");
        source.append("\n");
        source.append("import part1.lesson09.Worker;\n");
        source.append("\n");
        source.append("public class SomeClass implements Worker {\n");
        source.append("\n");
        source.append("    @Override\n");
        source.append("    public void doWork() {\n");
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите действия для метода \"doWork()\". Для введите с новой строки \"end\"");
            boolean isCoding = true;
            while (isCoding) {
                String code = reader.readLine();
                if (code.equalsIgnoreCase("end")) isCoding = false;
                else source.append(code + '\n');
            }
        }
//        source.append("        System.out.println(\"Hello world\");\n");
        source.append("    }\n");
        source.append("}\n");

//        File root = new File("\\Users\\Anton\\IdeaProjects\\InnopolisLessons\\JavaCore\\src");
        File root = new File("D:\\");
        File sourceFile = new File(root, "OOP\\SomeClass.java");
        Files.write(sourceFile.toPath(), source.toString().getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE);
//        Files.write(sourceFile.toPath(), source.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE);

// Compile source file.
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        compiler.run(null, null, null, sourceFile.getPath());

// Load and instantiate compiled class.
        URLClassLoader classLoader = URLClassLoader.newInstance(new URL[]{root.toURI().toURL()});
        Class<?> cls = Class.forName("OOP.SomeClass", true, classLoader); // Should print "hello".
        Object instance = cls.newInstance(); // Should print "world".
        if (instance instanceof Worker) ((Worker) instance).doWork();
    }
}