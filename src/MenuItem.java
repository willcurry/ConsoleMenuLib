public interface MenuItem<E> {
    String name();
    E execute(E e);
}
