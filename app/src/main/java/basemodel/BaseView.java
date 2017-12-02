package basemodel;

/**
 * Created by 木子 on 2017/11/23.
 */

public interface BaseView<T> {

    void seccuss(T t);

    void error(String msg);

    void Token(String msg);

    void netfailure(String msg);

}
