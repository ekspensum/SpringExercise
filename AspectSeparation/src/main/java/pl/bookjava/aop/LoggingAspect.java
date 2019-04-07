package pl.bookjava.aop;

public class LoggingAspect {

        public void logBefore() {
                System.out.println("Before call method getAllBook");
        }

        public void logAfter() {
                System.out.println("After call method getAllBooks");
        }

}
