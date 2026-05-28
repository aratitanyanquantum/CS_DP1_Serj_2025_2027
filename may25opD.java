class Student {
    private String sid;
    private String sname;
    private int sgrade;
    private String trass;
    private String fid;
    public int[] sPreferenceList = new int[10];

    public Student(String id, String name, int grade, int[] prefs) {
        sid = id;
        sname = name;
        sgrade = grade;
        sPreferenceList = prefs;
        trass = "zzz";
        fid = "";
    }

    public void setTripAssigned(String t) {
        trass = t;
    }

    public String getName() {
        return sname;
    }

    public String getTripAssigned() {
        return trass;
    }

    public String getFId() {
        return fid;
    }

    public void setFId(String f) {
        fid = f;
    }
}

class Trip {
    private int trnum;
    private String trtitle;
    private String trdesc;
    private int plfilled;
    private boolean running;
    private String[] tlist = new String[250];
    private int size;

    public Trip(int num, String title, String desc) {
        trnum = num;
        trtitle = title;
        trdesc = desc;
        plfilled = 0;
        running = false;
        size = 0;
    }

    public int getTripNumber() {
        return trnum;
    }

    public String getTripTitle() {
        return trtitle;
    }

    public String getTripDesc() {
        return trdesc;
    }

    public int getPlacesFilled() {
        return plfilled;
    }

    public boolean isRunning() {
        return running;
    }

    public String[] getList() {
        return tlist;
    }

    public int getSize() {
        return size;
    }

    public void setTripTitle(String title) {
        trtitle = title;
    }

    public void updatePlacesFilled() {
        plfilled++;

        if (plfilled >= 10) {
            running = true;
        }
    }

    public void addStudentToTripList(Student s) {
        tlist[size] = s.getName();
        size++;
    }
}

class AdventureTrip extends Trip {
    private boolean fit;
    private boolean shoes;

    public AdventureTrip(int n, String title, String desc, boolean f, boolean sh) {
        super(n, title, desc);
        fit = f;
        shoes = sh;
    }

    public boolean getFit() {
        return fit;
    }

    public boolean getShoes() {
        return shoes;
    }

    public void setFit(boolean f) {
        fit = f;
    }

    public void setShoes(boolean sh) {
        shoes = sh;
    }
}

class ServiceTrip extends Trip {
    private boolean comm;

    public ServiceTrip(int n, String title, String desc, boolean c) {
        super(n, title, desc);
        comm = c;
    }

    public boolean getComm() {
        return comm;
    }

    public void setComm(boolean c) {
        comm = c;
    }
}

class CultureTrip extends Trip {
    private boolean cam;

    public CultureTrip(int n, String title, String desc, boolean c) {
        super(n, title, desc);
        cam = c;
    }

    public boolean getCam() {
        return cam;
    }

    public void setCam(boolean c) {
        cam = c;
    }
}

class TripAllocator {
    private Trip[] trips = new Trip[16];
    private Student[] studs = new Student[250];
    private String[] alist = new String[250];
    private int asize = 0;

    public void assignTrip(Student s) {
        for (int i = 0; i < 10; i++) {
            int n = s.sPreferenceList[i];
            Trip t = trips[n - 1];

            if (t.getPlacesFilled() < 25) {
                s.setTripAssigned(t.getTripTitle());
                t.updatePlacesFilled();
                t.addStudentToTripList(s);
                return;
            }
        }
    }

    public void displayPlacesLeft() {
        for (int i = 0; i < trips.length; i++) {
            Trip t = trips[i];

            if (t.isRunning() && t.getPlacesFilled() < 25) {
                int left = 25 - t.getPlacesFilled();
                System.out.println("Trip " + t.getTripNumber() + ": " + t.getTripTitle() + " Places left: " + left);
            }
        }
    }

    public int noTrip() {
        int c = 0;

        for (int i = 0; i < studs.length; i++) {
            if (studs[i] != null && studs[i].getTripAssigned().equals("zzz")) {
                c++;
            }
        }

        return c;
    }

    public void avgPopularity(int[][] pop, int[] tripPop) {
        for (int i = 0; i < pop.length; i++) {
            int sum = 0;

            for (int j = 0; j < pop[i].length; j++) {
                sum += pop[i][j];
            }

            tripPop[i] = sum / pop[i].length;
        }
    }

    public void displayLowerPopularity(int[][] pop, int[] tripPop) {
        for (int i = 0; i < trips.length; i++) {
            if (pop[i][0] < tripPop[i]) {
                System.out.println(trips[i].getTripTitle());
            }
        }
    }

    public void aMethod2(int n) {
        for (int i = n; i >= 0; i--) {
            if (!trips[i].isRunning()) {
                for (int j = 0; j < trips[i].getSize(); j++) {
                    alist[asize] = trips[i].getList()[j];
                    asize++;
                }
            }
        }
    }
}

public class may25opD {
    public static void main(String[] args) {
        int[] p = {1, 3, 5, 2, 4, 6, 7, 8, 9, 10};

        Student s1 = new Student("s01", "Aram", 11, p);
        Trip t1 = new Trip(1, "Mountain", "Hiking");

        t1.addStudentToTripList(s1);
        t1.updatePlacesFilled();
        s1.setTripAssigned(t1.getTripTitle());

        System.out.println(s1.getName());
        System.out.println(s1.getTripAssigned());
    }
}