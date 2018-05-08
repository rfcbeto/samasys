package br.com.cadastro.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import br.com.cadastro.fto.PessoaFTO;

/**
 * @author roberto.coelho
 * 
 * Validação customizada.
 * Caso seja necessário ter validações muito específicas.
 * */
@Component 
public class PessoaValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return PessoaFTO.class.equals(clazz);
	}

	/**
	 * Recebe um object que será o seu objeto e um objeto do tipo Errors,
	 * Este metodo é responsável por validações muito específicas para o objeto em questão
	 * PessoaFTO.
	 */
	@Override
	public void validate(Object obj, Errors e) {
		ValidationUtils.rejectIfEmpty(e, "nome", "campo.vazio", "TESTE");
		
		PessoaFTO fto = (PessoaFTO)obj;
		if (fto.getCpf().isEmpty()) {
			e.rejectValue("cpf", "campos.vazio", "campo não poderá ser vazio!");
		}
	}
}
