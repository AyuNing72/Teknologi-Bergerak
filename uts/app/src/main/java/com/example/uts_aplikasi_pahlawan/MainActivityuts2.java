package com.example.uts_aplikasi_pahlawan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivityuts2 extends AppCompatActivity {
    ListView listpahlawan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activityuts2);

        String nama_palwn[]={"Pangeran Diponogoro" , "Ki Hadjar Dewantara",
                "R.A. Kartini" , "Tjoet Nyak Dien",
                "Soekarno" , "Bung Tomo",
                "H. Agus Salim" , "Sultan Hasanuddin"};

        int gambar_phlwn[]={R.drawable.diponogoro,R.drawable.dewantara,
                R.drawable.kartini,R.drawable.dien,
                R.drawable.sukarnoo, R.drawable.tomo,
                R.drawable.agus,R.drawable.hasanudin };

        String Keterangan_phlwn[]={"Pangeran Diponegoro berperan besar dalam memimpin Perang Jawa yang terjadi dalam kurun waktu lima tahun, yaitu pada tahun 1825 hingga 1830.\n" +
                "\n" + "Perang ini berkobar di hampir seluruh daerah di Pulau Jawa dan merupakan salah satu perang terbesar yang pernah terjadi dalam sejarah perjuangan melawan Belanda. " +
                "Walaupun berakhir dengan kemenangan Belanda, Pangeran Diponegoro sempat membuat Belanda mengalami kesulitan dan kerugian akibat gugurnya ribuan serdadu Belanda.",

                "Raden Mas Soewardi Soerjaningrat atau yang lebih dikenal dengan Ki Hadjar Dewantara merupakan salah satu aktivis pergerakan kemerdekaan. " +
                        "Sepanjang hidupnya, Ki Hadjar Dewantara telah berperan besar dalam pendidikan Indoensia.\n" +
                        "\n" + "Perguruan Taman Siswa adalah salah satu hasil jerih payahnya dalam memberikan kesempatan pendidikan bagi kaum pribumi Indonesia yang waktu itu hanya bisa dinikmati oleh masyarakat Belanda dan kalangan elit saja.",

                "Sebagai salah satu pahlawan wanita, Raden Adjeng Kartini telah berjasa dalam memperjuangkan kesetaraan hak kaum perempuan semasa hidupnya." +
                        "Latar belakang bangsawan tidak lantas membuatnya tunduk kepada para penguasa dan nilai-nilai mereka yang konservatif.\n" +
                        "Malah, Kartini dinilai telah memelopori bangkitnya perempuan pribumi dengan pemikirannya yang lebih moderat.",

                "Tjoet Nyak Dien merupakan pahlawan nasional perempuan yang berasal dari Aceh. Pada masa Perang Aceh, Cut Nyak Dien ikut melakukan perlawanan dengan memimpin rakyat Aceh untuk menyerang Belanda.\n" +
                        "Kematian Ibrahim Lamnga yang merupakan suami pertamanya dalam perang tersebut telah mengobarkan tekad dan semangat Cut Nyak Dien untuk menghentikan penjajahan Belanda.",

                "Berbicara tentang pahlawan kemerdekaan nasional Indonesia tidak bisa dilakukan tanpa sang proklamator kemerdekaan itu sendiri." +
                        "Ir. Soekarno adalah presiden pertama Indonesia yang juga berperan sebagai pencetus dasar negara Pancasila yang kita gunakan hingga saat ini.\n" +
                        "\n" + "Bersama dengan Mohammad Hatta, Soekarno merupakan tokoh penting yang telah menginspirasi masyarakat Indonesia dalam perjuangan mencapai gerbang kemerdekaan.",

                "Sutomo alias Bung Tomo, adalah salah satu pahlawan nasional asal Surabaya. Bung Tomo dikenal dengan aksi heroiknya saat membangkitkan semangat arek-arek Suroboyo dalam melawan kembali tentara Nederlandsch Indie Civil Administratie (NICA) Belanda dalam pertempuran 10 November.\n" +
                        "\n" + "Bung Tomo, yang juga merupakan seorang jurnalis asal Surabaya ini juga dikenal dengan semboyan “Merdeka atau Mati” dalam pertempuran berdarah di Surabaya tersebut. Pertempuran Surabaya kini diperingati sebagai Hari Pahlawan.",

                "Di awal bedirinya republik, Agus Salim memegang peran yang tidak kalah penting dibandingkan tokoh-tokoh pergerakan kebangsaan lainnya." +
                        "Namun, kiprah Agus Salim di pentas politik kemerdekaan sudah jauh ada sebelum era kemerdekaan. Agus Salim merupakan salah seorang pimpinan organisasi Islam terbesar kala itu yakni Serikat Islam.\n" +
                        "\n" + "Agus Salim yang dikenal menguasai berbagai macam bahasa asing ini juga dikenal sebagai seorang diplomat yang ulung.",

                "Dijuluki sebagai Ayam Jantan dari Timur, Sultan Hasanuddin adalah salah satu pahlawan kemerdekaan Indonesia yang berasal dari Sulawesi Selatan.\n" +
                        "\n" + "Setelah naik takhta menjadi sultan dari Kerajaan Gowa, ia berupaya menggabungkan kerajaan-kerajaan kecil Indonesia Timur dan memberikan perlawanan yang cukup sengit kepada pihak Kompeni Belanda."};

        listpahlawan=findViewById(R.id.ListdataPahlawan);
        AdapterPahlawan adapterPahlawan1=new AdapterPahlawan(this, nama_palwn, gambar_phlwn, Keterangan_phlwn);
        listpahlawan.setAdapter(adapterPahlawan1);
        listpahlawan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String aplwn=nama_palwn[position].toString();
                int ggbrplwn=gambar_phlwn[position];
                String kketplwn=Keterangan_phlwn[position].toString();

                //Toast.makeText(MainActivity.this,""+ggbrbuah, Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivityuts2.this,DetailPhlwn.class);
                intent.putExtra("nmaplwn",aplwn);
                intent.putExtra("gmbrplwn",ggbrplwn);
                intent.putExtra("pnjlsnplwn",kketplwn);
                startActivity(intent);
            }
        });

    }
}