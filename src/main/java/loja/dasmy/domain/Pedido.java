package loja.dasmy.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import loja.dasmy.enums.StatusPedido;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_pedido")
public class Pedido implements Serializable{

	private static final long serialVersionUID = 7873774518110777990L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "numero_pedido")
	private Long numeroPedido;
	
	@Column(name = "data_pedido")
	private LocalDate data;
	
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private StatusPedido status;
	
	@OneToOne
	@JoinColumn(name = "codigo_vendedor", referencedColumnName = "codigo")
	private Vendedor codigoVendedor;
	
	@OneToMany(mappedBy = "numeroPedido")
	private List<ItemPedido> itensPedido ;

	
	
}
