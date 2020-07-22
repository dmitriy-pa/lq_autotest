package lq_autotest.testcase;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lq_autotest.common.AuthBy;
import lq_autotest.common.User;
import lq_autotest.page.NewLetter;


public class Mail extends BaseWebTestcase {

	@Test
	@DisplayName("Отправка письма")
	@AuthBy(User.TestUser)
	public void send() {
		
		NewLetter newLetter = mailBox.NewLetter();
		
		//отправка письма самому себе
		newLetter.SetTo(getUser().name + getUser().domain);
		
		newLetter.SetSubject("Тестовое письмо");
		
		newLetter.SetBody("Тестовое сообщение");
		
		newLetter.Send();
	}
}
