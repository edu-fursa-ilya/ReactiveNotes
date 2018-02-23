package todo.com.fursa.mytodo.ui.mvp

import com.arellomobile.mvp.MvpView
import io.reactivex.Flowable
import todo.com.fursa.mytodo.data.model.Todo


interface IMainView : MvpView {
    fun hideEmptyListMessage()
    fun showEmptyListMessage()
    fun onNotesLoaded(notes: Flowable<List<Todo>>)
    fun showNotesList()
}