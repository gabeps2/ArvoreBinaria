class Elemento {
    public int num;
    public int matricula;
    public String nome;
    public String email;

    public Elemento dir;
    public Elemento esq;

    public Elemento() {
        num = 0;
        dir = null;
        esq = null;
    }
}

public class Arvore {

    public Elemento novo;
    public Elemento raiz;
    public Elemento aux;

    public Arvore() {
        novo = null;
        raiz = null;
    }

    public boolean inserir(int valor, int matricula, String nome, String email) {
        int achou;

        novo = new Elemento();

        novo.num = valor;
        novo.matricula = matricula;
        novo.nome = nome;
        novo.email = email;

        if (raiz == null) {
            raiz = novo;
        } else {
            aux = raiz;

            achou = 0;

            while (achou == 0) {
                if (novo.num < aux.num) {
                    if (aux.esq == null) {
                        aux.esq = novo;
                        achou = 1;
                    } else {
                        aux = aux.esq;
                    }
                } else if (novo.num > aux.num) {
                    if (aux.dir == null) {
                        aux.dir = novo;
                        achou = 1;
                    } else {
                        aux = aux.dir;
                    }
                } else if (novo.num == aux.num) {
                    return false;
                }
            }
        }
        return true;
    }

    public int pesquisar(int valor) {
        int altura = 0;

        aux = raiz;

        while (aux != null) {
            if (aux.num == valor) {
                return altura;
            } else if (valor < aux.num) {
                aux = aux.esq;
                altura++;
            } else {
                aux = aux.dir;
                altura++;
            }
        }
        return 1;
    }

    public void listarEMORDEM(Elemento x) {
        if (x != null) {
            listarEMORDEM(x.esq);
            System.out.printf("Número: %1$d\n", x.num);
            System.out.printf("Matrícula: %1$d\n", x.matricula);
            System.out.printf("Nome: %1$s\n", x.nome);
            System.out.printf("E-mail: %1$s\n\n", x.email);
            listarEMORDEM(x.dir);
        }
    }

    public void listarPREORDEM(Elemento x) {
        if (x != null) {
            System.out.printf("Número: %1$d\n", x.num);
            System.out.printf("Matrícula: %1$d\n", x.matricula);
            System.out.printf("Nome: %1$s\n", x.nome);
            System.out.printf("E-mail: %1$s\n\n", x.email);
            listarEMORDEM(x.esq);
            listarEMORDEM(x.dir);
        }
    }

    public void listarPOSORDEM(Elemento x) {
        if (x != null) {
            listarEMORDEM(x.esq);
            listarEMORDEM(x.dir);
            System.out.printf("Número: %1$d\n", x.num);
            System.out.printf("Matrícula: %1$d\n", x.matricula);
            System.out.printf("Nome: %1$s\n", x.nome);
            System.out.printf("E-mail: %1$s\n\n", x.email);
        }
    }

    public Elemento excluir(Elemento x, int valor) {
        Elemento aux1, aux2;

        if (valor == x.num) {
            if (x.esq == x.dir) {
                return null;
            } else if (x.esq == null) {
                return x.dir;
            } else if (x.dir == null) {
                return x.esq;
            } else {
                aux1 = x.dir;
                aux2 = x.dir;

                while (aux1.esq != null) {
                    aux1 = aux1.esq;
                }

                aux1.esq = x.esq;

                return aux2;
            }
        } else if (valor > x.num) {
            x.dir = excluir(x.dir, valor);
        } else {
            x.esq = excluir(x.esq, valor);
        }

        return x;
    }
}