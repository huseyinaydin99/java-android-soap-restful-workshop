package tr.com.huseyinaydin;

//بسم الله الرحمن الرحيم

/**
*
* @author Huseyin_Aydin
* @since 1994
* @category Java, Android, WebServis, SOAP.
*
*/

public abstract class SelamWSCallbackHandler {

	protected Object clientData;

	public SelamWSCallbackHandler(Object clientData) {
		this.clientData = clientData;
	}

	public SelamWSCallbackHandler() {
		this.clientData = null;
	}

	public Object getClientData() {
		return clientData;
	}

	public void receiveResultselamVerUcParametreli(
			tr.com.huseyinaydin.SelamWSStub.SelamVerUcParametreliResponse result) {
	}

	public void receiveErrorselamVerUcParametreli(java.lang.Exception e) {
	}

	public void receiveResultselamVerIkiParametreli(
			tr.com.huseyinaydin.SelamWSStub.SelamVerIkiParametreliResponse result) {
	}

	public void receiveErrorselamVerIkiParametreli(java.lang.Exception e) {
	}

	public void receiveResultselamVer(tr.com.huseyinaydin.SelamWSStub.SelamVerResponse result) {
	}

	public void receiveErrorselamVer(java.lang.Exception e) {
	}
}