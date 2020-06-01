package part1.lesson09;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
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
        StringBuilder source = new StringBuilder();

        source.append("import part1.lesson09.Worker;\n");
        source.append("\n");
        source.append("public class SomeClass implements Worker {\n");
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

        source.append("    }\n");
        source.append("}\n");

        File root = new File("./");
        File sourceFile = new File(root, "SomeClass.java");
        Files.write(sourceFile.toPath(), source.toString().getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE);

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        compiler.run(null, null, null, sourceFile.getPath());

        Class<?> cls = new MyLoader().loadClass("SomeClass");
        Object instance = cls.newInstance();
        ((Worker) instance).doWork();
    }
}