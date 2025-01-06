package io.sumith.helper;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class CreateClassTemplate {

    public static void main(String[] args) throws Exception {
        String className = args[0];
        createJavaClassFile(className);
    }

    public static void createJavaClassFile(String className) throws Exception {

        String packageName = className.substring(0, className.lastIndexOf('.'));
        String simpleClassName = className.substring(className.lastIndexOf('.') + 1);

        if(Character.isLowerCase(simpleClassName.charAt(0))){
            throw new Exception("First letter of class name should be capital.");
        }

        String packagePath = packageName.replace('.', '/');
        File dir = new File("src/main/java/" + packagePath);

        if (!dir.exists()) {
            dir.mkdirs();
        }

        File classFile = new File(dir, simpleClassName + ".java");

        if(classFile.exists()){
            throw new Exception("Class Already Exist");
        }

        String classTemplate = getTemplateFromResource();

        if (classTemplate == null) {
            System.err.println("Error: Template file could not be found or read.");
            return;
        }

        classTemplate = classTemplate.replace("{packageName}", packageName)
                .replace("{className}", simpleClassName);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(classFile))) {
            writer.write(classTemplate);
            System.out.println("Class " + simpleClassName + " has been created successfully at " + classFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("An error occurred while creating the class: " + e.getMessage());
        }
    }

    private static String getTemplateFromResource() {
        StringBuilder templateContent = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                Objects.requireNonNull(CreateClassTemplate.class.getClassLoader().getResourceAsStream("helper/template.txt")), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                templateContent.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the template: " + e.getMessage());
            return null;
        }

        return templateContent.toString();
    }
}
