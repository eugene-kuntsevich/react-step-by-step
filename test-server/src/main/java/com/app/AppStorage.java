package com.app;

import com.app.model.Car;
import com.app.model.Client;
import com.app.model.Master;
import com.app.model.Order;
import com.app.model.OrderStatus;
import java.util.HashMap;
import java.util.Map;

public final class AppStorage {

  private static final Client client1 = new Client(1L, "Normie", "Crady", "+379362847290");
  private static final Client client2 = new Client(2L, "Delmor", "Desseine", "+3713623407221");
  private static final Client client3 = new Client(3L, "Marven", "Lope", "+381202847401");
  private static final Client client4 = new Client(4L, "Fred", "Stone", "+341802847287");

  private static final Car car1 = new Car(1L, "4810NM-01", client1);
  private static final Car car2 = new Car(2L, "9472HP-03", client2);
  private static final Car car3 = new Car(3L, "1605AK-02", client3);
  private static final Car car4 = new Car(4L, "2610AK-04", client4);

  private static final Master master1 = new Master(1L, "Bayard", "Kausche");
  private static final Master master2 = new Master(2L, "Delaney", "Mallion");
  private static final Master master3 = new Master(3L, "Cheri", "Rubenfeld");
  private static final Master master4 = new Master(4L, "Max", "Pain");

  private static final OrderStatus waitingStart = new OrderStatus(1L,
      "Waiting start of maintenance");
  private static final OrderStatus inProgress = new OrderStatus(2L, "Maintenance in progress");
  private static final OrderStatus finished = new OrderStatus(3L, "Maintenance was finished");

  private static final Order order1 = new Order(1L, waitingStart, null, master1);
  private static final Order order2 = new Order(2L, inProgress, car2, null);
  private static final Order order3 = new Order(3L, finished, car3, master3);
  private static final Order order4 = new Order(4L, finished, car4, master4);

  private static final Map<Long, Car> immutableCarsMap = Map
      .of(1L, car1, 2L, car2, 3L, car3, 4L, car4);
  private static final Map<Long, Master> immutableMastersMap = Map
      .of(1L, master1, 2L, master2, 3L, master3, 4L, master4);
  private static final Map<Long, OrderStatus> immutableOrderStatusesMap = Map
      .of(1L, waitingStart, 2L, inProgress, 3L, finished);
  private static final Map<Long, Order> immutableOrdersMap = Map
      .of(1L, order1, 2L, order2, 3L, order3, 4L, order4);

  public static Long carIdGenerator = 1000L;
  public static Long masterIdGenerator = 2000L;
  public static Long orderStatusIdGenerator = 3000L;
  public static Long orderIdGenerator = 4000L;

  public static Map<Long, Car> cars = new HashMap<>(immutableCarsMap);
  public static Map<Long, Master> masters = new HashMap<>(immutableMastersMap);
  public static Map<Long, OrderStatus> orderStatuses = new HashMap<>(immutableOrderStatusesMap);
  public static Map<Long, Order> orders = new HashMap<>(immutableOrdersMap);

  {
    master3.setOrder(order3);
    master4.setOrder(order4);
  }
}
