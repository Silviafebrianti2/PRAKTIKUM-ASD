package TUGAS;

public class AntrianLayanan26 {
    Mahasiswa26[] data;
    int front;
    int rear;
    int size;
    int max;

    int jumlahDiproses; // jumlah mahasiswa yang sudah proses KRS

    public AntrianLayanan26(int max) {
        this.max = max;
        data = new Mahasiswa26[max];
        front = 0;
        rear = -1;
        size = 0;
        jumlahDiproses = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == max;
    }

    public void clear() {
        if (isEmpty()) {
            System.out.println("Antrian sudah kosong.");
        } else {
            front = 0;
            rear = -1;
            size = 0;
            System.out.println("Antrian berhasil dikosongkan.");
        }
    }

    public void tambahAntrian(Mahasiswa26 mhs) {
        if (isFull()) {
            System.out.println("Antrian penuh, tidak bisa menambah mahasiswa.");
            return;
        }

        rear = (rear + 1) % max;
        data[rear] = mhs;
        size++;

        System.out.println(mhs.nama + " berhasil masuk antrian.");
    }

    // proses KRS: 1x panggil melayani 2 mahasiswa
    public void prosesKRS() {
        if (isEmpty()) {
            System.out.println("Antrian kosong, tidak ada mahasiswa untuk diproses.");
            return;
        }

        System.out.println("Mahasiswa yang diproses KRS:");

        // melayani maksimal 2 mahasiswa
        for (int i = 0; i < 2; i++) {
            if (!isEmpty()) {
                Mahasiswa26 mhs = data[front];
                front = (front + 1) % max;
                size--;

                jumlahDiproses++;
                mhs.tampilkanData();
            }
        }
    }

    public void tampilkanSemua() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }

        System.out.println("Daftar Mahasiswa dalam Antrian:");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % max;
            System.out.print((i + 1) + ". ");
            data[index].tampilkanData();
        }
    }

    public void tampilkan2Terdepan() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }

        System.out.println("2 Mahasiswa Terdepan:");

        for (int i = 0; i < 2; i++) {
            if (i < size) {
                int index = (front + i) % max;
                System.out.print((i + 1) + ". ");
                data[index].tampilkanData();
            }
        }
    }

    public void lihatAkhir() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.println("Mahasiswa paling belakang:");
            data[rear].tampilkanData();
        }
    }

    public int getJumlahAntrian() {
        return size;
    }

    public int getJumlahDiproses() {
        return jumlahDiproses;
    }

    public int getBelumDiproses() {
        return 30 - jumlahDiproses;
    }
}
