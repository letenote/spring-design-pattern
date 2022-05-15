package letenote.designpattern.factory.socialmedia;

import lombok.Getter;

public class InstagramSocialMedia implements SocialMediaInterface {
	@Getter
	private final String name = "Instagram";
	@Getter
	private final String url = "https://instagram.com";
	@Getter
	private final SocialMediaType type = SocialMediaType.INSTAGRAM;

	@Override
	public String toString() {
		return "InstagramSocialMedia{" +
				"name='" + name + '\'' +
				", url='" + url + '\'' +
				", type=" + type +
				'}';
	}
}
