package np.com.rewardskotlin

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.recyclerview_item_row.view.*

/**
 * Created by brainnovation on 12/1/17.
 */
class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private var view: View = view
    private var userName: String? = null

    fun bindUser(userName: String) {
        this.userName = userName;
        view.txtName.setText(userName)

    }

}