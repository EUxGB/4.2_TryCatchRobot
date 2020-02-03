public class Robot implements RobotConnectionManager, RobotConnection {
    int x;
    int y;
    Direction look;


    public Robot(int x, int y, Direction look) {
        this.x = x;
        this.y = y;
        this.look = look;
    }

    public Direction getDirection() {

        return look;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction turnLeft() {

        if (look.ordinal() == 0) return look = Direction.LEFT;
        return look = Direction.values()[look.ordinal() - 1];// повернуться на 90 градусов против часовой стрелки
    }

    public Direction turnRight() {
        if (look.ordinal() == 3) return look = Direction.UP;
        return look = Direction.values()[look.ordinal() + 1];// повернуться на 90 градусов по часовой стрелке
    }

    public int stepForward() {
//        if (look== Direction.UP) return
//            || look.ordinal()== 2 )
        switch (look.ordinal()) {
            case (0): //UP
                y = y + 1;
                return y;
            case (2): //DOWN
                y = y - 1;
                return y;
            case (1): //RIGHT
                x = x + 1;
                return x;
            case (3): //LEFT
                x = x - 1;
                return x;


        }
        return 0;
        // шаг в направлении взгляда мс
        // за один шаг робот изменяет одну свою координату на единицу
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        int dX = robot.getX() - toX;
        int dY = robot.getY() - toY;
        //Direction startLook = robot.getDirection();
        System.out.println("Начальное положение : " + robot.look + "  x: " + robot.x + "  y :" + robot.y);
        System.out.println("Точка назначения :      " + "  x: " + toX + "  y :" + toY + "\n");
        if (dX < 0)  // нужно двигаться вправо
        {
            Direction endLook = Direction.RIGHT;
            while (robot.getDirection() != endLook) {
                robot.turnRight();
                System.out.println("Повернул направо");
            }

        }
        if (dX > 0)  // нужно двигаться влево
        {
            Direction endLook = Direction.LEFT;
            while (robot.getDirection() != endLook) {
                robot.turnLeft();
                System.out.println("Повернул налево");
            }


        }
        int i = 0;
        while (robot.getX() != toX) {
            robot.stepForward();
            i++;
            //System.out.println("Шаг");
        }
        System.out.println("Количество шагов вперед " + i);
        if (dY < 0) {  // нужно двигаться вверх
            Direction endLook = Direction.UP;
            while (robot.getDirection() != endLook) {
                robot.turnRight();
                System.out.println("Повернул направо");
            }


        }
        if (dY > 0)  // нужно двигаться вниз
        {
            Direction endLook = Direction.DOWN;
            while (robot.getDirection() != endLook) {
                robot.turnRight();
                System.out.println("Повернул направо");
            }


        }
        i = 0;
        while (robot.getY() != toY) {
            robot.stepForward();
            i++;
            // System.out.println("Шаг");
        }
        System.out.println("Количество шагов вперед " + i + "\n");
        System.out.println("Контроль местонахождения : " + robot.look + "  x: " + robot.x + "  y :" + robot.y);
        return;

    }

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        robotConnectionManager.getConnection();
        // your implementation here
    }


    @Override
    public void moveRobotTo(int x, int y) {
        System.out.println("Начальное положение : " + this.getDirection() + "  x: " + this.getX() + "  y :" + this.getY());
        this.x = x;
        this.y = y;
        System.out.println("Контроль местонахождения : " + this.getDirection() + "  x: " + this.getX() + "  y :" + this.getY());

    }

    @Override
    public void close() {
    }

    @Override
    public RobotConnection getConnection() {
        return null;
    }
}
