package lq_autotest.testcase;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lq_autotest.common.AuthBy;
import lq_autotest.common.User;
import lq_autotest.page.NewLetter;


public class Mail extends BaseWebTestcase {

	@Test
	@DisplayName("�������� ������")
	@AuthBy(User.TestUser)
	public void send() {
		
		NewLetter newLetter = mailBox.NewLetter();
		
		//�������� ������ ������ ����
		newLetter.SetTo(getUser().name + getUser().domain);
		
		newLetter.SetSubject("�������� ������");
		
		newLetter.SetBody("�������� ���������");
		
		newLetter.Send();
	}
}
