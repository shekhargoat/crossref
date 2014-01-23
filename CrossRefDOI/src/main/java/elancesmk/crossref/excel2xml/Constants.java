package elancesmk.crossref.excel2xml;

public interface Constants {
	public static final String contributorXml="<person_name sequence = \"first\" contributor_role = \"author" +
			"\"><given_name>[FN]</given_name><surname>[LN]</surname></person_name>";
	public static final String bodyXML="<body><report-paper><report-paper_metadata language = \"en\"><contributors>[AUTHORS]</contributors><titles><title>[TITLE]</title></titles><edition_number>0</edition_number><publication_date media_type = \"online\"><year>[YOP]</year></publication_date><publisher><publisher_name>ICTSD International Centre for Trade and Sustainable Development</publisher_name></publisher><publisher_item><item_number item_number_type=\"OSTI\">41946</item_number></publisher_item><doi_data><doi>10.7215/[DOI]</doi><resource>[URL]</resource></doi_data></report-paper_metadata></report-paper></body>";
	public static final String mainXml="<?xml version=\"1.0\" encoding=\"UTF-8\"?><doi_batch version=\"4.3.0\" xmlns=" +
			"\"http://www.crossref.org/schema/4.3.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.crossref.org/schema/4.3.0 http://www.crossref.org/schema/deposit/crossref4.3.0.xsd\"><head><doi_batch_id>240114</doi_batch_id><timestamp>[TIMESTAMP]</timestamp><depositor><name>ICTSD International Centre for Trade and Sustainable Development</name><email_address>gpascolini@ictsd.ch</email_address></depositor><registrant>OSTI</registrant></head>[BODY]</doi_batch>";
}
