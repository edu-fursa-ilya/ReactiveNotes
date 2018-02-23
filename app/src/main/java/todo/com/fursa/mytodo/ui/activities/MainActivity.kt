package todo.com.fursa.mytodo.ui.activities

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import io.reactivex.Flowable
import kotlinx.android.synthetic.main.activity_main.*
import todo.com.fursa.mytodo.R
import todo.com.fursa.mytodo.data.model.Todo
import todo.com.fursa.mytodo.ui.mvp.IMainView
import todo.com.fursa.mytodo.ui.mvp.MainPresenter
import todo.com.fursa.mytodo.ui.recycler.TodoAdapter
import todo.com.fursa.mytodo.utils.TodoApplication

class MainActivity : MvpAppCompatActivity(), IMainView {
    @InjectPresenter
    lateinit var presenter: MainPresenter

    private var todoAdapter: TodoAdapter = TodoAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        TodoApplication.component.inject(this)
        presenter.loadAllNotes()

        fab.setOnClickListener {
            presenter.addNewNote(Todo("Test title", "Test text"))
        }
    }

    override fun hideEmptyListMessage() {
        tvEmpty.visibility = View.GONE
    }

    override fun showEmptyListMessage() {
        tvEmpty.visibility = View.VISIBLE
    }

    override fun onNotesLoaded(notes: Flowable<List<Todo>>) {
        notes.forEach { todoAdapter.setDataSource(it) }
    }

    override fun showNotesList() {
        rvNotes.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager?
        rvNotes.adapter = todoAdapter
        rvNotes.visibility = View.VISIBLE
    }


}



