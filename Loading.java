public class Loading {
    private static char[] ch = { '|', '/', '-', '\\' };

    public static void loadingAnimationOne() {
        while (true) {
            for (int i = 0; i < ch.length; i++) {
                System.out.print("\r" + ch[i]);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void loadingAnimationTwo() {
        while (true) {
            for (int i = 0; i < 5; i++) {
                System.out.print(".");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print("\r     \r");
        }
    }

    public static void loadingAnimationThree() {
        // [==============================>------------------] 66.67% 1.3s
        // [===============================>-----------------] 70.00% 1.4s
        for (int i = 0; i <= 100; i++) {
            System.out.print("\r[");
            for (int j = 0; j < i; j++) {
                System.out.print("=");
            }
            System.out.print(">");
            for (int j = i; j < 100; j++) {
                System.out.print("-");
            }
            System.out.print("] " + i + "%");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }
    public static void loadingAnimationFour() {
        // [=====================55%=====================>------------------]
        // one = represents 2%
        for (int i = 0; i <= 100; i++) {
            System.out.print("\r[");
            for (int j = 0; j < i / 2; j++) {
                System.out.print("=");
            }
            System.out.print(i + "%");
            for (int j = i / 2; j < 50; j++) {
                System.out.print("-");
            }
            System.out.print(">]");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }  
    }
    public static void loadingAnimationFive() {
        // [=====================55%=====================>------------------]
        // one = represents 2%
        // display N% always at the same position in the center
        for (int i = 0; i <= 100; i++) {
            System.out.print("\r[");
            for (int j = 0; j < i / 2; j++) {
                System.out.print("=");
            }
            System.out.print(i + "%");
            for (int j = i / 2; j < 50; j++) {
                System.out.print("-");
            }
            System.out.print(">]");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Loading...");
        // loadingAnimationOne();
        // loadingAnimationTwo();
        // loadingAnimationThree();
        // loadingAnimationFour();
        loadingAnimationFive();
    }
}
