package com.app;

import com.app.model.Car;
import com.app.model.Client;
import com.app.model.Master;
import com.app.model.Order;
import com.app.model.OrderStatus;
import java.util.HashMap;
import java.util.Map;

public final class AppStorage {

  private static final Client client1 = new Client("Normie", "Crady", "+379362847290");
  private static final Client client2 = new Client("Delmor", "Desseine", "+3713623407221");
  private static final Client client3 = new Client("Marven", "Lope", "+381202847401");
  private static final Client client4 = new Client("Fred", "Stone", "+341802847287");

  private static final Car car1 = new Car(105001L, "4810NM-01", client1);
  private static final Car car2 = new Car(105002L, "9472HP-03", client2);
  private static final Car car3 = new Car(105003L, "1605AK-02", client3);
  private static final Car car4 = new Car(105004L, "2610AK-04", client4);

  private static final Master master1 = new Master(20501L, "Bayard", "Kausche");
  private static final Master master2 = new Master(20502L, "Delaney", "Mallion");
  private static final Master master3 = new Master(20503L, "Cheri", "Rubenfeld");
  private static final Master master4 = new Master(20504L, "Max", "Pain");

  private static final OrderStatus waitingStart = new OrderStatus(30501L, "Waiting of maintenance");
  private static final OrderStatus inProgress = new OrderStatus(30502L, "Maintenance in progress");
  private static final OrderStatus finished = new OrderStatus(30503L, "Maintenance was finished");

  private static final Order order1 = new Order(40501L, waitingStart, car1, master1);
  private static final Order order2 = new Order(40502L, inProgress, car2, master2);
  private static final Order order3 = new Order(40503L, finished, car3, master3);
  private static final Order order4 = new Order(40504L, finished, car4, master4);

  private static final Map<Long, Car> immutableCarsMap = Map
      .of(105001L, car1, 105002L, car2, 105003L, car3, 105004L, car4);
  private static final Map<Long, Master> immutableMastersMap = Map
      .of(20501L, master1, 20502L, master2, 20503L, master3, 20504L, master4);
  private static final Map<Long, OrderStatus> immutableOrderStatusesMap = Map
      .of(30501L, waitingStart, 30502L, inProgress, 30503L, finished);
  private static final Map<Long, Order> immutableOrdersMap = Map
      .of(40501L, order1, 40502L, order2, 40503L, order3, 40504L, order4);

  public static Long carIdGenerator = 10600L;
  public static Long masterIdGenerator = 20600L;
  public static Long orderStatusIdGenerator = 30600L;
  public static Long orderIdGenerator = 40600L;

  public static Map<Long, Car> cars = new HashMap<>(immutableCarsMap);
  public static Map<Long, Master> masters = new HashMap<>(immutableMastersMap);
  public static Map<Long, OrderStatus> orderStatuses = new HashMap<>(immutableOrderStatusesMap);
  public static Map<Long, Order> orders = new HashMap<>(immutableOrdersMap);

  static {
    master3.setOrder(order3);
    master4.setOrder(order4);
    car1.setOrder(order1);
    car2.setOrder(order2);
    car3.setOrder(order3);
    car4.setOrder(order4);
  }
}
