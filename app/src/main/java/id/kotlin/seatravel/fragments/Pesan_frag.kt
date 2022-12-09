package id.kotlin.seatravel.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.kotlin.seatravel.R
import id.kotlin.seatravel.helper.Model
import id.kotlin.seatravel.helper.PesanAdapter


class pesan_frag : Fragment() {

    private lateinit var adapter: PesanAdapter
    private lateinit var recyclerView : RecyclerView
    private lateinit var listPesan : ArrayList<Model>

    lateinit var image : Array<Int>
    lateinit var kapal : Array<String>
    lateinit var desc : Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pesan_frag, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInitialize()

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.list_pesanan)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = PesanAdapter(listPesan)
        recyclerView.adapter = adapter
    }


    private fun dataInitialize(){
        listPesan = arrayListOf()

        image = arrayOf(
            R.drawable.advanture,
            R.drawable.allure,
            R.drawable.aria,
            R.drawable.avalon,
            R.drawable.brilliance,
            R.drawable.celebrity,
            R.drawable.costa,
        )

        kapal = arrayOf(
            getString(R.string.head_1),
            getString(R.string.head_2),
            getString(R.string.head_3),
            getString(R.string.head_4),
            getString(R.string.head_5),
            getString(R.string.head_6),
            getString(R.string.head_7),
        )

        desc = arrayOf(
            getString(R.string.desc_1),
            getString(R.string.desc_2),
            getString(R.string.desc_3),
            getString(R.string.desc_4),
            getString(R.string.desc_5),
            getString(R.string.desc_6),
            getString(R.string.desc_7),
        )

        for (i in image.indices){
            val data = Model(image[i], kapal[i], desc[i])
            listPesan.add(data)
        }
    }
}
