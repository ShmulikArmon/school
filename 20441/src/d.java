/**
 * Created by Shmuliks on 07-Jan-17.
 *
 */

class h {
    static void g(int n, int d){

    }
}

interface f
{

}

class a implements f {
}

//cant b abstract, has constructor. also b does not inherit from a it implements it.
//a could not possibly inherent from b since that would create cyclical inheritence.
class b implements f {
    b(c t, int s) {

    }
}

class c {

}

class d {
    void a() {
        c t = new c();

        int s = 0, n = 0, d = 0;

        a x = new b(t, s);
        //d cant be method, does not have braces
        h.g(n, d);

    }
    public static void main(String[] args){

    }
}

