package np.com.rewardskotlin

import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), DeveloverListAdapter.OnLoadMoreListener {


    private lateinit var itemListAdapter: DeveloverListAdapter
    var isLoading: Boolean = false
    var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        rvList.layoutManager = layoutManager
        itemListAdapter = DeveloverListAdapter(getItems());
        itemListAdapter.setLoadMoreListener(this);
        rvList.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        rvList.adapter = itemListAdapter;


    }


    fun getItems(): MutableList<String> {
        val userList = mutableListOf<String>()
        for (item: Int in 1..10) {
            userList.add("data" + count)
            count += 1
        }
        return userList;
    }

    override fun onLoadMore() {
        if (!isLoading) {
            isLoading = true
            android.os.Handler().postDelayed({
                itemListAdapter.notifyLoading()
                rvList.smoothScrollToPosition(itemListAdapter.itemCount)
            }, 200)

        }

        Handler().postDelayed({
            isLoading = false;
            val userList = mutableListOf<String>()
            for (item: Int in 1..10) {
                userList.add("data" + count)
                count += 1
            }
            itemListAdapter.addMoreData(userList)
        }, 30 * 1000)
    }

}
