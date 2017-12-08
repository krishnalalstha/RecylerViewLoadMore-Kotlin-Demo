package np.com.rewardskotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar

/**
 * Created by brainnovation on 12/1/17.
 */
abstract class BaseActivity : AppCompatActivity() {
    protected val toolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}