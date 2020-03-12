package com.zszurman.liczniki

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")

class MainActivity : AppCompatActivity() {

    private lateinit var cardViewAdapter: CardViewAdapter

    companion object X {
        var measurement = 0
        var screen = 0
        var alexVisible = 0
        var currentId = 100
        var currentName = ""
        var currentSubtitle = ""
        var cC = 1
        lateinit var list: ArrayList<Counter>
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (screen == 1) finish()
        if (alexVisible == 0) layoutAlex.visibility = View.INVISIBLE
        else layoutAlex.visibility = View.VISIBLE


        Preference.getAllPref(this)
        initRecyclerView()
        btn.setOnClickListener {
            measurement = meterView.value
            when (currentId) {
                0 -> Data.p01 = meterView.value
                10 -> Data.p11 = meterView.value
                1 -> Data.p02 = meterView.value
                11 -> Data.p12 = meterView.value
                2 -> Data.p03 = meterView.value
                12 -> Data.p13 = meterView.value
                3 -> Data.p04 = meterView.value
                13 -> Data.p14 = meterView.value
            }
            Preference.setAllPref(this)
            currentId = 100
            onResume()
            layoutAlex.visibility = View.INVISIBLE
            alexVisible = 0
        }
    }

    override fun onResume() {
        super.onResume()
        meterView.value = measurement
        initRecyclerView()
        if (alexVisible == 0) {
            layoutAlex.visibility = View.INVISIBLE
            currentId = 100
        } else layoutAlex.visibility = View.VISIBLE
        setActionBar(currentId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Preference.setAllPref(this)
        screen = 0
        alexVisible = 0
    }

    private fun initRecyclerView() {
        list = Data.makeList()
        rv.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 1)
            cardViewAdapter = CardViewAdapter(this@MainActivity)
            adapter = cardViewAdapter
            cardViewAdapter.acceptList(list)
            cardViewAdapter.notifyDataSetChanged()
        }
    }

    private fun setActionBar(id: Int) {
        val mActionBar = supportActionBar
        if (id == 100 && cC == 1) {
            currentName = "Masz 1 licznik"
            currentSubtitle = "Klikaj i aktualizuj pomarańczowe odczyty"
        } else if (id == 100) {
            currentName = "Masz $cC liczniki"
            currentSubtitle = "Klikaj i aktualizuj pomarańczowe odczyty"
        }
        mActionBar?.title = currentName
        mActionBar?.subtitle = currentSubtitle
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item != null) {
            when (item.itemId) {
                R.id.action_sort -> showSortDialog()
            }
            when (item.itemId) {
                R.id.action_info -> showMessage()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showSortDialog() {
        val pref = Preference(this)
        val sortOptions =
            arrayOf("1 licznik", "2 liczniki", "3 liczniki", "4 liczniki")
        val mBuilder = AlertDialog.Builder(this)
        mBuilder.setTitle("Wybierz ilość liczników")
        mBuilder.setIcon(R.mipmap.ic_launcher_round)
        mBuilder.setSingleChoiceItems(sortOptions, -1) { dialogInterface, i ->
            when (i) {
                0 -> {
                    cC = 1
                    pref.setCC(cC)
                    onResume()
                    Toast.makeText(this, "Masz 1 licznik", Toast.LENGTH_SHORT).show()
                }
                1 -> {
                    cC = 2
                    pref.setCC(cC)
                    onResume()
                    Toast.makeText(this, "Masz 2 liczniki", Toast.LENGTH_SHORT).show()
                }
                2 -> {
                    cC = 3
                    pref.setCC(cC)
                    onResume()
                    Toast.makeText(this, "Masz 3 liczniki", Toast.LENGTH_SHORT).show()
                }
                3 -> {
                    cC = 4
                    pref.setCC(cC)
                    onResume()
                    Toast.makeText(this, "Masz 4 liczniki", Toast.LENGTH_SHORT).show()
                }
            }
            dialogInterface.dismiss()
        }
        val mDialog = mBuilder.create()
        mDialog.show()
    }

    private fun showMessage() {
        val title = getString(R.string.title_message)
        val message: String =
            "1. Aplikacja przeznaczona jest do monitorowania miesięcznych wydatków " +
                    "związanych ze zużyciem mediów zaopatrzonych w liczniki (np. paliwo, woda, gaz, energia elektryczna itd.) " +
                    "Zakłada ona, że co miesiąc podajesz odczyty generujące miesięczny rachunek. " +
                    "Dlatego dla każdego licznika podajesz właśnie ten dzień miesiąca w zakresie od 1 do 28 (bo nie każdy miesiąc " +
                    "ma więcej niż 28 dni). Jeżeli odczyty podajesz ostatniego dnia miesiąca, to zastąp go pierwszym dniem. " +
                    "Aplikacja wylicza prognozowany rachunek miesięczny na podstawie bieżącego zużycie i w ten sposób " +
                    "informuje Cię, jak bieżące zużycie wpłynie na wysokość rachunku miesięcznego (rachunek prognozowany). " +
                    "Poza tym wylicza aktualne: zużycie, koszt i rachunek.\n\n" +

                    "2. Możesz wybrać do 4 liczników." +
                    "W trakcie korzystania z aplikacji możesz zmieniać ilość liczników. Ukrycie licznika nie spowoduje " +
                    "utraty jego danych, stanie się po prostu niewidoczny. Po ponownym zwiększeniu liczby liczników " +
                    "zostaną one pokazane. " +
                    "Jeżeli chcesz ukryć licznik z góry, to przesuń wyżej licznik położony niżej, gdyż liczniki będą ukrywane od " +
                    "od dołu.\n\n" +

                    "3. Wprowadzaj odczyty początkowy i " +
                    "aktualny, klikając na pomarańczowe liczby. Po pojawieniu się wirtualnego licznika, " +
                    "ustaw żądaną wartość i zaakceptuj ją.\n\n" +

                    "4. Kliknij przycisk edytuj i przejdź  do  edycji licznika. Znajdziesz tam wskazówki dotyczące edycji.\n\n" +

                    "5. Z powodzeniem możesz też monitorować ilość wypitego piwa (wypalonych paczek papierosów itp.) " +
                    "w miesiącu i zobaczyć jakie koszty to generuje. Rachunek aktualny uwzględnia koszty stałe, " +
                    "np. zakup nowego kufla.\n\n" +

                    "6. Kontroluj swoje rachunki, ale bez przesady, czasami daj się ponieść.\n\n" +
                    "Miłej zabawy!\n" +
                    "Zbigniew Szurman "

        val builder = AlertDialog.Builder(this@MainActivity)
        builder.setCancelable(true)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.show()
    }
}

