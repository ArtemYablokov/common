package main.java.innerClasses;

public class OuterClass extends Parent {

    class InnerClass{

        void cantChangeName(){
            cantChangeName(); // это просто РЕКУРСИЯ НА СЕБЯ
            this.cantChangeName(); // аналогично

            // нам нужен метод ( например унаследованный) и у которого мы не можем менять название
            OuterClass.this.cantChangeName(); // вот так обратимся к методу внешнего класса ! через его ссылку
        }
    }
}

class Parent {
    void cantChangeName(){}
}

