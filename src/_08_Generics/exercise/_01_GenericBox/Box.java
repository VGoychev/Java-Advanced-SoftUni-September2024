package _08_Generics.exercise._01_GenericBox;

public class Box<T> {
        private T value;

        public Box(T value){
            this.value = value;
        }

        @Override
        public String toString(){
            return String.format("%s: %s", this.value.getClass().getName(), this.value);
        }

}
