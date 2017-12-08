package np.com.rewardskotlin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by brainnovation on 11/29/17.
 */
class DeveloverListAdapter(private val list: MutableList<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    lateinit var onloadMoreListener: OnLoadMoreListener

    override fun getItemCount() = list.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == 0) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item_row, parent, false)
            return UserViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item_loading, parent, false)
            return LoadingViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        if (position == list.size - 1) {
            onloadMoreListener.onLoadMore()
        }
        if (holder is UserViewHolder) {
            val currentItem: String = list.get(position)
            holder.bindUser(currentItem)
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (list.get(position).contentEquals("Loading")) {
            return 1;
        } else {
            return 0
        }
    }

    fun setLoadMoreListener(onLoadMoreListener: OnLoadMoreListener) {
        this.onloadMoreListener = onLoadMoreListener
    }


    interface OnLoadMoreListener {

        fun onLoadMore()

    }

    fun notifyLoading() {
        val pos = list.size
        list.add("Loading")
        notifyItemInserted(pos)

    }

    fun addMoreData(userList: MutableList<String>) {
        list.removeAt(list.size - 1)
        notifyItemRemoved(list.size)
        list.addAll(userList)
        notifyItemRangeInserted(list.size + 1, userList.size)
    }

}