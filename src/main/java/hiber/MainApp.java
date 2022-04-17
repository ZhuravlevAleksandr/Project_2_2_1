package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("Aleksandr", "Zhuravlev", "zhuravlevAleksandr@gmail.com");
      User user2 = new User("Roman", "Smirnov", "smirnovRoman@gmail.com");
      User user3 = new User("Sergey", "Graevskiy", "graevskiySergey@gmail.com");
      User user4 = new User("Varvara", "Zhuravleva", "zhuravlevaVarvara@gmail.com");

      Car car1 = new Car("BMW", 2022);
      Car car2 = new Car("Kia", 2015);
      Car car3 = new Car("Mitsubishi", 2005);
      Car car4 = new Car("Volkswagen", 2021);

      userService.add(user1.setCar(car1).setUser(user1));
      userService.add(user2.setCar(car2).setUser(user2));
      userService.add(user3.setCar(car3).setUser(user3));
      userService.add(user4.setCar(car4).setUser(user4));

      for (User user : userService.listUsers()) {
         System.out.println(user + " " + user.getCar());
      }

      System.out.println(userService.getUserByCar("Mitsubishi", 2005));

      context.close();
   }
}
