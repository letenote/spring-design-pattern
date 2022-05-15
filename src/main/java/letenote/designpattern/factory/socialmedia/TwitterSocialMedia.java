package letenote.designpattern.factory.socialmedia;

import lombok.Getter;

public class TwitterSocialMedia implements SocialMediaInterface {
	@Getter
	private final String name = "Twitter";
	@Getter
	private final String url = "https://twitter.com";
	@Getter
	private final SocialMediaType type = SocialMediaType.TWITTER;

	@Override
	public String toString() {
		return "TwitterSocialMedia{" +
				"name='" + name + '\'' +
				", url='" + url + '\'' +
				", type=" + type +
				'}';
	}
}
