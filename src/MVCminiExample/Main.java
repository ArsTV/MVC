package MVCminiExample;

public class Main {
	public static void main(String[] args){
		Controller controller = new Controller();
		controller.execute();
	}
	
	

}

class Student{
	private String name = "Shohn";
	private int age = 19;
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public int getAge(){
		return age;
	}
	void setAge(int age){
		this.age = age;
	}
}

interface ModelLayer{
	Student getStudent();
}

class DBLayer implements ModelLayer{

	@Override
	public Student getStudent() {
		return new Student();
	}
	
}

interface View{
	void showStudent(Student student);
}

class ConsoleView implements View{
	@Override
	public void showStudent(Student student) {
		System.out.println("Student name: " + student.getName() + ", age: " + student.getAge());		
	}	
}
class HtmlView implements View{
	@Override
	public void showStudent(Student student) {
		System.out.println("<html><body>Student name: " + student.getName() + 
				", age: " + student.getAge() + "</body></html>");		
	}	
}

class Controller{
	ModelLayer modelLayer = new DBLayer();
	View view = new ConsoleView();
	void execute(){
		Student student = modelLayer.getStudent();
		view.showStudent(student);
	}
}
