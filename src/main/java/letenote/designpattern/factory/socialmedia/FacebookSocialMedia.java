package letenote.designpattern.factory.socialmedia;

import lombok.Getter;

public class FacebookSocialMedia implements SocialMediaInterface {
	@Getter
	private final String name = "Facebook";
	@Getter
	private final String url = "https://facebook.com";
	@Getter
	private final SocialMediaType type = SocialMediaType.FACEBOOK;

	@Override
	public String toString() {
		return "FacebookSocialMedia{" +
				"name='" + name + '\'' +
				", url='" + url + '\'' +
				", type=" + type +
				'}';
	}
}
