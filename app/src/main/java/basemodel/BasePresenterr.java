package basemodel;

/**
 * Created by 木子 on 2017/11/23.
 */

public class BasePresenterr<T extends BaseView> {

    public T v;

    public BasePresenterr(T view) {
        this.v = view;
    }

    public void destory() {
        v = null;
    }
}
