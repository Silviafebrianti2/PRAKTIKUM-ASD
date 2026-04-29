package P2Jobsheet10;

public class AntrianLayanan26 {
    Mahasiswa26[] data;
    int front;
    int rear;
    int size;
    int max;

    public AntrianLayanan26(int max) {
        this.max = max;
        this.data = new Mahasiswa26[max];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == max;
    }

    public void tambahAntrian(Mahasiswa26 mhs) {
        if (isFull()) {
            System.out.println("Antrian penuh, tidak dapat menambah mahasiswa.");
            return; 
        }

        rear = (rear + 1) % max;
        data[rear] = mhs;
        size++;
        System.out.println(mhs.nama + " berhasil masuk ke antrian.");
    }

    public Mahasiswa26 layananMahasiswa() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return null;
        }

        Mahasiswa26 mhs = data[front];
        front = (front + 1) % max;
        size--;

        return mhs;
    }

    public void tampilkanSemua() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }

        System.out.println("Daftar Mahasiswa dalam Antrian:");
        System.out.println("NIM - PRODI - KELAS");

        for (int i = 0; i < size; i++) {
            int index = (front + i) % max;
            System.out.print((i + 1) + ". ");
            data[index].tampilkanData();
        }
    }
    public void lihatTerdepan() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.println("Mahasiswa terdepan:");
            data[front].tampilkanData();
        }
    }
    public void lihatAkhir() {
    if (isEmpty()) {
        System.out.println("Antrian kosong.");
    } else {
        System.out.print("Mahasiswa paling belakang: ");
        data[rear].tampilkanData();
    }
}
    public int getJumlahAntrian() {
        return size;
    }
}