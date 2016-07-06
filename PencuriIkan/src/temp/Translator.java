/*
* @author Sudono Tanjung
* @2016
*/
package temp;

import java.io.IOException;
import java.io.InputStream;
import Custom.Google.*;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import langCode.LanguageCode;

/**
 * @author sud_tanj
 *
 */
public class Translator {
	private GoogleSpeechSynthesis sound = null;
	protected String text = null;
	protected String translatedText = null;
	private InputStream translatedTextSound=null;
	private Player translatedTextSoundPlayer=null;
	private String clientId=null;

	private InputStream getTranslatedTextSound() {
		return translatedTextSound;
	}

	private void setTranslatedTextSound(InputStream translatedTextSound) {
		this.translatedTextSound = translatedTextSound;
	}
	private String getTranslatedText() {
		return translatedText;
	}

	private void setTranslatedText(String translatedText) {
		this.translatedText = translatedText;
	}

	public Translator(String clientId) {
	   setClientId(clientId);
	}
	
	private String getClientId() {
		return clientId;
	}

	private void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String translate(String text, String languageTo) {
		if(text.equals(this.text))
			return getTranslatedText();
		setText(text);
		for (LanguageCode code : LanguageCode.values()) {
			if (code.getName().equals(languageTo)){
				try {
					setTranslatedText(GoogleTranslate.translate(code.toString(), text));
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			}
		}
		return getTranslatedText();
	}

	private void setSound(GoogleSpeechSynthesis sound) {
		this.sound = sound;
	}

	private GoogleSpeechSynthesis getSound() {
		return sound;
	}

	private Player getTranslatedTextSoundPlayer() {
		return translatedTextSoundPlayer;
	}

	private void setTranslatedTextSoundPlayer(Player translatedTextSoundPlayer) {
		this.translatedTextSoundPlayer = translatedTextSoundPlayer;
	}
	public String translateAndSpeak(String text, String languageTo) {
		if(text.equals(this.text)){
			try {
				getTranslatedTextSoundPlayer().play();
			} catch (JavaLayerException e) {
				e.printStackTrace();
			}
			return getTranslatedText();
		}
		translate(text, languageTo);
		setSound(new GoogleSpeechSynthesis(getClientId()));
		try {
			setTranslatedTextSound(getSound().getMP3Data(getTranslatedText()));
			setTranslatedTextSoundPlayer(new Player(getTranslatedTextSound()));
			getTranslatedTextSoundPlayer().play();
			setTranslatedTextSoundPlayer(null);
		} catch (IOException | JavaLayerException e) {
			e.printStackTrace();
		}
		setSound(null);
		System.gc();
		return getTranslatedText();
	}

	private void setText(String text) {
		this.text = text;
	}
}
