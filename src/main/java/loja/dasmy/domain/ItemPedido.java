package loja.dasmy.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_item_pedido")
public class ItemPedido implements Serializable{

	private static final long serialVersionUID = -2545148383552497719L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "numseq")
	private Long numeroSequencia;
	
	@Column(name = "numero_pedido")
	private Long numeroPedido;
	
	@Column(name = "codigo_Item")
	private Long codigoItem;

}
