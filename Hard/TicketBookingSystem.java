class TicketBookingSystem {
    private static final int TOTAL_SEATS = 10;
    private static boolean[] seats = new boolean[TOTAL_SEATS];
    private static final Object lock = new Object();

    static class BookingThread extends Thread {
        int seatNumber;
        boolean isVIP;

        BookingThread(int seatNumber, boolean isVIP) {
            this.seatNumber = seatNumber;
            this.isVIP = isVIP;
            if (isVIP) setPriority(Thread.MAX_PRIORITY);
        }

        public void run() {
            synchronized (lock) {
                if (seats[seatNumber]) {
                    System.out.println("Error: Seat " + seatNumber + " already booked.");
                } else {
                    seats[seatNumber] = true;
                    System.out.println((isVIP ? "VIP" : "Regular") + " Booking: Seat " + seatNumber + " confirmed.");
                }
            }
        }
    }

    public static void main(String[] args) {
        BookingThread t1 = new BookingThread(1, true);
        BookingThread t2 = new BookingThread(1, false);
        BookingThread t3 = new BookingThread(2, false);
        t1.start();
        t2.start();
        t3.start();
    }
}
