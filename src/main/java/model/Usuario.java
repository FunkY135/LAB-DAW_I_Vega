package model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "tb_usuarios")
@Data
@NoArgsConstructor
public class Usuario{
	public Usuario(int i, String string, String string2, String string3, String string4, String string5, int j, int k) {
		// TODO Auto-generated constructor stub
	}

	@Id
	private int cod_usua;
	private String nom_usua;
	private String ape_usua;
	private String usr_usua;
	private String cla_usua;
	private String fna_usua;
	private int idtipo;
	private int est_usua;
	
	@ManyToOne
	@JoinColumn(name ="idtipo", insertable = false, updatable = false)
	private Tipo objTipo;
}