package com.javarush.task.task20.task2004;

import java.io.*;

/* 
Читаем и пишем в файл статики
*/
public class Solution {

    public static void main(String[] args) throws Exception {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        File yourFile = File.createTempFile("your_file_name", null);
        OutputStream outputStream = new FileOutputStream(yourFile);
        InputStream inputStream = new FileInputStream(yourFile);
        ClassWithStatic classWithStatic = new ClassWithStatic();
        classWithStatic.i = 3;
        classWithStatic.j = 4;
        classWithStatic.save(outputStream);
        outputStream.flush();
        ClassWithStatic loadedObject = new ClassWithStatic();
        loadedObject.staticString = "something";
        loadedObject.i = 6;
        loadedObject.j = 7;
        loadedObject.load(inputStream);
        //here check that the classWithStatic object is equal to the loadedObject object - проверьте тут, что classWithStatic и loadedObject равны
        outputStream.close();
        inputStream.close();
    }

    public static class ClassWithStatic {

        public static String staticString = "This is a static test string";
        public int i;
        public int j;

        public void save(OutputStream outputStream) throws Exception {
            PrintStream writer = new PrintStream(outputStream);
            writer.println(staticString != null ? "yes" : "no");
            if (staticString != null) writer.println(staticString);
            writer.println(i);
            writer.println(j);
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            if (reader.readLine().equals("yes")) staticString = reader.readLine();
            i = Integer.parseInt(reader.readLine());
            j = Integer.parseInt(reader.readLine());
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ClassWithStatic that = (ClassWithStatic) o;
            if (i != that.i) return false;
            return j == that.j;
        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + j;
            return result;
        }
    }
}
