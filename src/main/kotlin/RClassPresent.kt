import data.Student
import data.studentList
import org.w3c.dom.events.Event
import react.*
import react.dom.li
import react.dom.ol

interface RClassPresentProps : RProps {
    var students: Array<Student>
}
interface RClassPresentState: RState{
    var present: Array<Boolean>
}

class RClassPresent: RComponent<RClassPresentProps, RClassPresentState>() {

    override fun componentWillMount() {
        state.apply {
            present = Array(props.students.size) { false }
        }
    }

    fun onClick(index:Int): (Event) -> Unit = {
        setState {
            state.present[index] = !state.present[index]
        }
    }

    override fun RBuilder.render() {
        +"English"
        val click = props.students.mapIndexed { index, student -> onClick(index) }
            studentList(props.students, state.present, click)
    }
}

     fun RBuilder.classPresent(students: Array<Student>) =
        child(RClassPresent::class) {
            attrs.students = students
        }


