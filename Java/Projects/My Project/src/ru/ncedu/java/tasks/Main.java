package ru.ncedu.java.tasks;

import javax.naming.NamingException;
import java.io.File;

public class Main{
//    public static void main(String[] args) throws IOException, URISyntaxException, AWTException, InterruptedException, NoSuchAlgorithmException {
//        //Создадим экземпляр класса ВКапи
//        VKapi vkAPI = new VKapi();
//        //Получим токен
//        vkAPI.setConnection();
//        //Бескоечный цикл
//        String oldMessage = vkAPI.getNewMessage();
//        String newMessage;
//        int i = 0;
//        for (; ; ) {
//            // Запросы на сервер можно подавать раз в 3 секунды
//            Thread.sleep(3000); // ждем три секунды
//            if (i == 15000) {  // Если прошло 45 000 сек (Время взято с запасом, токен дается на день )
//                vkAPI.setConnection(); // Обновляем токен
//                Thread.sleep(3000);    // Запросы шлем только раз в три секунды
//                i = 0;
//            }
//            //Здесь отработка
//            newMessage = vkAPI.getNewMessage();
//            if (!newMessage.equals(oldMessage)) {
//                oldMessage = newMessage;
//                System.out.println("Получено новое сообщение");
//            }
//            i++;
//        }
//    }

    public static void main(String[] args) throws NamingException {
//        Repository repository = new XMLRepository();
//        Console control = new Console(repository);
//        control.callConsole();
//        System.out.printf("%s %<s %<s", "a", "b", "c");
        File f = new File("file");
        File[] files = f.list;
    }
}