public class FacadeDescuento {

        // guarda en las variables una instancia de cada otra
        private ApiTarjeta apiTarjeta;
        private ApiProducto apiProducto;
        private ApiCantidad apiCantidad;

        // constructor que crea las instancias
        public FacadeDescuento() {
            apiTarjeta  = new ApiTarjeta() ;
            apiProducto = new ApiProducto() ;
            apiCantidad = new ApiCantidad() ;
        }

        //  simplifica el descuento
        public int descuento(Tarjeta tarj, Producto prod, int cant) {
            int elDescuento = 0;
            elDescuento = elDescuento + apiCantidad.descuento(cant);
            elDescuento = elDescuento + apiProducto.descuento(prod);
            elDescuento = elDescuento + apiTarjeta.descuento(tarj);
            return elDescuento;
        }

}
