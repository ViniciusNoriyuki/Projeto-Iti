package br.com.itau.iti.utils.enums;

public enum StatusConta {
    AGUARDANDO{
        public String toString(){
            return "AGUARDANDO";
        }
    },
    ABERTA{
        public String toString(){
            return "ABERTA";
        }
    },
    INATIVA{
        public String toString(){
            return "INATIVA";
        }
    }
}
