package com.zaoqibu.jiegeflag.domain;

import java.util.ArrayList;
import java.util.List;

public class World 
{
	private List<Continent> continents = new ArrayList<Continent>();
	
	public World()
	{
//		continents.add(getAsia());
//		continents.add(getAfrica());
//		continents.add(getNorthAmerica());
//		continents.add(getSouthAmerica());
//		continents.add(getEurope());
//		continents.add(getOceania());
	}

    public void addContinent(Continent continent) {
        continents.add(continent);
    }
	
	public int getContinentCount()
	{
		return continents.size();
	}
	
	public Continent getContinentByIndex(int index)
	{
		return continents.get(index);
	}
	
//	private Continent getAsia()
//	{
//		Continent continent = new Continent(R.drawable.continent_asia, "亚洲");
//		continent.AddCountry(new Country(R.drawable.china, R.raw.china));
//		continent.AddCountry(new Country(R.drawable.japan, R.raw.japan));
//		continent.AddCountry(new Country(R.drawable.north_korea, R.raw.north_korea));
//		continent.AddCountry(new Country(R.drawable.south_korea, R.raw.south_korea));
//		continent.AddCountry(new Country(R.drawable.mongolia, R.raw.mongolia));
//		continent.AddCountry(new Country(R.drawable.thailand, R.raw.thailand));
//		continent.AddCountry(new Country(R.drawable.philippines, R.raw.philippines));
//		continent.AddCountry(new Country(R.drawable.indonesia, R.raw.indonesia));
//		continent.AddCountry(new Country(R.drawable.vietnam, R.raw.vietnam));
//		continent.AddCountry(new Country(R.drawable.brunei, R.raw.brunei));
//		continent.AddCountry(new Country(R.drawable.singapore, R.raw.singapore));
//		continent.AddCountry(new Country(R.drawable.malaysia, R.raw.malaysia));
//		continent.AddCountry(new Country(R.drawable.laos, R.raw.laos));
//		continent.AddCountry(new Country(R.drawable.cambodia, R.raw.cambodia));
//		continent.AddCountry(new Country(R.drawable.east_timor, R.raw.east_timor));
//		continent.AddCountry(new Country(R.drawable.myanmar, R.raw.myanmar));
//		continent.AddCountry(new Country(R.drawable.india, R.raw.india));
//		continent.AddCountry(new Country(R.drawable.pakistan, R.raw.pakistan));
//		continent.AddCountry(new Country(R.drawable.sri_lanka, R.raw.sri_lanka));
//		continent.AddCountry(new Country(R.drawable.nepal, R.raw.nepal));
//		continent.AddCountry(new Country(R.drawable.maldives, R.raw.maldives));
//		continent.AddCountry(new Country(R.drawable.bhutan, R.raw.bhutan));
//		continent.AddCountry(new Country(R.drawable.bangladesh, R.raw.bangladesh));
//		continent.AddCountry(new Country(R.drawable.afghanistan, R.raw.afghanistan));
//		continent.AddCountry(new Country(R.drawable.uzbekistan, R.raw.uzbekistan));
//		continent.AddCountry(new Country(R.drawable.kyrgyzstan, R.raw.kyrgyzstan));
//		continent.AddCountry(new Country(R.drawable.kazakhstan, R.raw.kazakhstan));
//		continent.AddCountry(new Country(R.drawable.tajikistan, R.raw.tajikistan));
//		continent.AddCountry(new Country(R.drawable.turkmenistan, R.raw.turkmenistan));
//		continent.AddCountry(new Country(R.drawable.jordan, R.raw.jordan));
//		continent.AddCountry(new Country(R.drawable.turkey, R.raw.turkey));
//		continent.AddCountry(new Country(R.drawable.lebanon, R.raw.lebanon));
//		continent.AddCountry(new Country(R.drawable.israel, R.raw.israel));
//		continent.AddCountry(new Country(R.drawable.kuwait, R.raw.kuwait));
//		continent.AddCountry(new Country(R.drawable.qatar, R.raw.qatar));
//		continent.AddCountry(new Country(R.drawable.united_arab_emirates, R.raw.united_arab_emirates));
//		continent.AddCountry(new Country(R.drawable.syria, R.raw.syria));
//		continent.AddCountry(new Country(R.drawable.iran, R.raw.iran));
//		continent.AddCountry(new Country(R.drawable.saudi_arabia, R.raw.saudi_arabia));
//		continent.AddCountry(new Country(R.drawable.turkish_republic_of_northern_cyprus, R.raw.turkish_republic_of_northern_cyprus));
//		continent.AddCountry(new Country(R.drawable.palestine, R.raw.palestine));
//		continent.AddCountry(new Country(R.drawable.yemen, R.raw.yemen));
//		continent.AddCountry(new Country(R.drawable.armenia, R.raw.armenia));
//		continent.AddCountry(new Country(R.drawable.south_ossetia, R.raw.south_ossetia));
//		continent.AddCountry(new Country(R.drawable.azerbaijan, R.raw.azerbaijan));
//		continent.AddCountry(new Country(R.drawable.abkhazia, R.raw.abkhazia));
//		continent.AddCountry(new Country(R.drawable.oman, R.raw.oman));
//		continent.AddCountry(new Country(R.drawable.bahrain, R.raw.bahrain));
//		continent.AddCountry(new Country(R.drawable.georgia, R.raw.georgia));
//		continent.AddCountry(new Country(R.drawable.cyprus, R.raw.cyprus));
//		continent.AddCountry(new Country(R.drawable.iraq, R.raw.iraq));
//
//		return continent;
//	}
//
//	private Continent getAfrica()
//	{
//		Continent continent = new Continent(R.drawable.continent_africa, "非洲");
//		continent.AddCountry(new Country(R.drawable.morocco, R.raw.morocco));
//		continent.AddCountry(new Country(R.drawable.algeria, R.raw.algeria));
//		continent.AddCountry(new Country(R.drawable.sudan, R.raw.sudan));
//		continent.AddCountry(new Country(R.drawable.sahrawi_arab_democratic_republic, R.raw.sahrawi_arab_democratic_republic));
//		continent.AddCountry(new Country(R.drawable.egypt, R.raw.egypt));
//		continent.AddCountry(new Country(R.drawable.tunisia, R.raw.tunisia));
//		continent.AddCountry(new Country(R.drawable.south_sudan, R.raw.south_sudan));
//		continent.AddCountry(new Country(R.drawable.libya, R.raw.libya));
//		continent.AddCountry(new Country(R.drawable.somalia, R.raw.somalia));
//		continent.AddCountry(new Country(R.drawable.uganda, R.raw.uganda));
//		continent.AddCountry(new Country(R.drawable.kenya, R.raw.kenya));
//		continent.AddCountry(new Country(R.drawable.tanzania, R.raw.tanzania));
//		continent.AddCountry(new Country(R.drawable.djibouti, R.raw.djibouti));
//		continent.AddCountry(new Country(R.drawable.burundi, R.raw.burundi));
//		continent.AddCountry(new Country(R.drawable.eritrea, R.raw.eritrea));
//		continent.AddCountry(new Country(R.drawable.seychelles, R.raw.seychelles));
//		continent.AddCountry(new Country(R.drawable.rwanda, R.raw.rwanda));
//		continent.AddCountry(new Country(R.drawable.ethiopia, R.raw.ethiopia));
//		continent.AddCountry(new Country(R.drawable.liberia, R.raw.liberia));
//		continent.AddCountry(new Country(R.drawable.guinea, R.raw.guinea));
//		continent.AddCountry(new Country(R.drawable.mauritania, R.raw.mauritania));
//		continent.AddCountry(new Country(R.drawable.chad, R.raw.chad));
//		continent.AddCountry(new Country(R.drawable.niger, R.raw.niger));
//		continent.AddCountry(new Country(R.drawable.cote_divoire, R.raw.cote_divoire));
//		continent.AddCountry(new Country(R.drawable.togo, R.raw.togo));
//		continent.AddCountry(new Country(R.drawable.senegal, R.raw.senegal));
//		continent.AddCountry(new Country(R.drawable.nigeria, R.raw.nigeria));
//		continent.AddCountry(new Country(R.drawable.mali, R.raw.mali));
//		continent.AddCountry(new Country(R.drawable.sierra_leone, R.raw.sierra_leone));
//		continent.AddCountry(new Country(R.drawable.the_gambia, R.raw.the_gambia));
//		continent.AddCountry(new Country(R.drawable.ghana, R.raw.ghana));
//		continent.AddCountry(new Country(R.drawable.guinea_bissau, R.raw.guinea_bissau));
//		continent.AddCountry(new Country(R.drawable.burkina_faso, R.raw.burkina_faso));
//		continent.AddCountry(new Country(R.drawable.benin, R.raw.benin));
//		continent.AddCountry(new Country(R.drawable.cape_verde, R.raw.cape_verde));
//		continent.AddCountry(new Country(R.drawable.central_african_republic, R.raw.central_african_republic));
//		continent.AddCountry(new Country(R.drawable.gabon, R.raw.gabon));
//		continent.AddCountry(new Country(R.drawable.cameroon, R.raw.cameroon));
//		continent.AddCountry(new Country(R.drawable.sao_tome_and_principe, R.raw.sao_tome_and_principe));
//		continent.AddCountry(new Country(R.drawable.equatorial_guinea, R.raw.equatorial_guinea));
//		continent.AddCountry(new Country(R.drawable.republic_of_the_congo, R.raw.republic_of_the_congo));
//		continent.AddCountry(new Country(R.drawable.democratic_republic_of_the_congo, R.raw.democratic_republic_of_the_congo));
//		continent.AddCountry(new Country(R.drawable.madagascar, R.raw.madagascar));
//		continent.AddCountry(new Country(R.drawable.botswana, R.raw.botswana));
//		continent.AddCountry(new Country(R.drawable.swaziland, R.raw.swaziland));
//		continent.AddCountry(new Country(R.drawable.mauritius, R.raw.mauritius));
//		continent.AddCountry(new Country(R.drawable.angola, R.raw.angola));
//		continent.AddCountry(new Country(R.drawable.zimbabwe, R.raw.zimbabwe));
//		continent.AddCountry(new Country(R.drawable.mozambique, R.raw.mozambique));
//		continent.AddCountry(new Country(R.drawable.namibia, R.raw.namibia));
//		continent.AddCountry(new Country(R.drawable.south_africa, R.raw.south_africa));
//		continent.AddCountry(new Country(R.drawable.zambia, R.raw.zambia));
//		continent.AddCountry(new Country(R.drawable.comoros, R.raw.comoros));
//		continent.AddCountry(new Country(R.drawable.lesotho, R.raw.lesotho));
//		continent.AddCountry(new Country(R.drawable.malawi, R.raw.malawi));
//
//		return continent;
//	}
//
//	private Continent getNorthAmerica()
//	{
//		Continent continent = new Continent(R.drawable.continent_north_america, "北美洲");
//		continent.AddCountry(new Country(R.drawable.united_states, R.raw.united_states));
//		continent.AddCountry(new Country(R.drawable.canada, R.raw.canada));
//		continent.AddCountry(new Country(R.drawable.mexico, R.raw.mexico));
//		continent.AddCountry(new Country(R.drawable.panama, R.raw.panama));
//		continent.AddCountry(new Country(R.drawable.costa_rica, R.raw.costa_rica));
//		continent.AddCountry(new Country(R.drawable.nicaragua, R.raw.nicaragua));
//		continent.AddCountry(new Country(R.drawable.el_salvador, R.raw.el_salvador));
//		continent.AddCountry(new Country(R.drawable.honduras, R.raw.honduras));
//		continent.AddCountry(new Country(R.drawable.guatemala, R.raw.guatemala));
//		continent.AddCountry(new Country(R.drawable.belize, R.raw.belize));
//		continent.AddCountry(new Country(R.drawable.dominica_republic, R.raw.dominica_republic));
//		continent.AddCountry(new Country(R.drawable.cuba, R.raw.cuba));
//		continent.AddCountry(new Country(R.drawable.jamaica, R.raw.jamaica));
//		continent.AddCountry(new Country(R.drawable.trinidad_and_tobago, R.raw.trinidad_and_tobago));
//		continent.AddCountry(new Country(R.drawable.barbados, R.raw.barbados));
//		continent.AddCountry(new Country(R.drawable.antigua_and_barbuda, R.raw.antigua_and_barbuda));
//		continent.AddCountry(new Country(R.drawable.bahamas, R.raw.bahamas));
//		continent.AddCountry(new Country(R.drawable.grenada, R.raw.grenada));
//		continent.AddCountry(new Country(R.drawable.dominica, R.raw.dominica));
//		continent.AddCountry(new Country(R.drawable.saint_kitts_and_nevis, R.raw.saint_kitts_and_nevis));
//		continent.AddCountry(new Country(R.drawable.saint_vincent_and_the_grenadines, R.raw.saint_vincent_and_the_grenadines));
//		continent.AddCountry(new Country(R.drawable.haiti, R.raw.haiti));
//		continent.AddCountry(new Country(R.drawable.saint_lucia, R.raw.saint_lucia));
//
//		return continent;
//	}
//
//	private Continent getSouthAmerica()
//	{
//		Continent continent = new Continent(R.drawable.continent_south_america, "南美洲");
//		continent.AddCountry(new Country(R.drawable.chile, R.raw.chile));
//		continent.AddCountry(new Country(R.drawable.uruguay, R.raw.uruguay));
//		continent.AddCountry(new Country(R.drawable.peru, R.raw.peru));
//		continent.AddCountry(new Country(R.drawable.bolivia, R.raw.bolivia));
//		continent.AddCountry(new Country(R.drawable.colombia, R.raw.colombia));
//		continent.AddCountry(new Country(R.drawable.argentina, R.raw.argentina));
//		continent.AddCountry(new Country(R.drawable.guyana, R.raw.guyana));
//		continent.AddCountry(new Country(R.drawable.suriname, R.raw.suriname));
//		continent.AddCountry(new Country(R.drawable.brazil, R.raw.brazil));
//		continent.AddCountry(new Country(R.drawable.venezuela, R.raw.venezuela));
//		continent.AddCountry(new Country(R.drawable.ecuador, R.raw.ecuador));
//		continent.AddCountry(new Country(R.drawable.paraguay, R.raw.paraguay));
//
//		return continent;
//	}
//
//	private Continent getEurope()
//	{
//		Continent continent = new Continent(R.drawable.continent_europe, "欧洲");
//		continent.AddCountry(new Country(R.drawable.france, R.raw.france));
//		continent.AddCountry(new Country(R.drawable.united_kingdom, R.raw.united_kingdom));
//		continent.AddCountry(new Country(R.drawable.netherlands, R.raw.netherlands));
//		continent.AddCountry(new Country(R.drawable.belgium, R.raw.belgium));
//		continent.AddCountry(new Country(R.drawable.monaco, R.raw.monaco));
//		continent.AddCountry(new Country(R.drawable.ireland, R.raw.ireland));
//		continent.AddCountry(new Country(R.drawable.luxembourg, R.raw.luxembourg));
//		continent.AddCountry(new Country(R.drawable.denmark, R.raw.denmark));
//		continent.AddCountry(new Country(R.drawable.norway, R.raw.norway));
//		continent.AddCountry(new Country(R.drawable.sweden, R.raw.sweden));
//		continent.AddCountry(new Country(R.drawable.iceland, R.raw.iceland));
//		continent.AddCountry(new Country(R.drawable.finland, R.raw.finland));
//		continent.AddCountry(new Country(R.drawable.switzerland, R.raw.switzerland));
//		continent.AddCountry(new Country(R.drawable.poland, R.raw.poland));
//		continent.AddCountry(new Country(R.drawable.czech_republic, R.raw.czech_republic));
//		continent.AddCountry(new Country(R.drawable.austria, R.raw.austria));
//		continent.AddCountry(new Country(R.drawable.germany, R.raw.germany));
//		continent.AddCountry(new Country(R.drawable.liechtenstein, R.raw.liechtenstein));
//		continent.AddCountry(new Country(R.drawable.hungary, R.raw.hungary));
//		continent.AddCountry(new Country(R.drawable.slovakia, R.raw.slovakia));
//		continent.AddCountry(new Country(R.drawable.latvia, R.raw.latvia));
//		continent.AddCountry(new Country(R.drawable.estonia, R.raw.estonia));
//		continent.AddCountry(new Country(R.drawable.ukraine, R.raw.ukraine));
//		continent.AddCountry(new Country(R.drawable.russia, R.raw.russia));
//		continent.AddCountry(new Country(R.drawable.lithuania, R.raw.lithuania));
//		continent.AddCountry(new Country(R.drawable.belarus, R.raw.belarus));
//		continent.AddCountry(new Country(R.drawable.san_marino, R.raw.san_marino));
//		continent.AddCountry(new Country(R.drawable.portugal, R.raw.portugal));
//		continent.AddCountry(new Country(R.drawable.vatican_city, R.raw.vatican_city));
//		continent.AddCountry(new Country(R.drawable.italy, R.raw.italy));
//		continent.AddCountry(new Country(R.drawable.malta, R.raw.malta));
//		continent.AddCountry(new Country(R.drawable.greece, R.raw.greece));
//		continent.AddCountry(new Country(R.drawable.spain, R.raw.spain));
//		continent.AddCountry(new Country(R.drawable.romania, R.raw.romania));
//		continent.AddCountry(new Country(R.drawable.moldova, R.raw.moldova));
//		continent.AddCountry(new Country(R.drawable.bulgaria, R.raw.bulgaria));
//		continent.AddCountry(new Country(R.drawable.croatia, R.raw.croatia));
//		continent.AddCountry(new Country(R.drawable.slovenia, R.raw.slovenia));
//		continent.AddCountry(new Country(R.drawable.albania, R.raw.albania));
//		continent.AddCountry(new Country(R.drawable.macedonia, R.raw.macedonia));
//		continent.AddCountry(new Country(R.drawable.andorra, R.raw.andorra));
//		continent.AddCountry(new Country(R.drawable.bosnia_and_herzegovina, R.raw.bosnia_and_herzegovina));
//		continent.AddCountry(new Country(R.drawable.montenegro, R.raw.montenegro));
//		continent.AddCountry(new Country(R.drawable.kosovo, R.raw.kosovo));
//		continent.AddCountry(new Country(R.drawable.serbia, R.raw.serbia));
//
//		return continent;
//	}
//
//	private Continent getOceania()
//	{
//		Continent continent = new Continent(R.drawable.continent_oceania, "大洋洲");
//		continent.AddCountry(new Country(R.drawable.tonga, R.raw.tonga));
//		continent.AddCountry(new Country(R.drawable.new_zealand, R.raw.new_zealand));
//		continent.AddCountry(new Country(R.drawable.australia, R.raw.australia));
//		continent.AddCountry(new Country(R.drawable.samoa, R.raw.samoa));
//		continent.AddCountry(new Country(R.drawable.nauru, R.raw.nauru));
//		continent.AddCountry(new Country(R.drawable.fiji, R.raw.fiji));
//		continent.AddCountry(new Country(R.drawable.papua_new_guinea, R.raw.papua_new_guinea));
//		continent.AddCountry(new Country(R.drawable.solomon_islands, R.raw.solomon_islands));
//		continent.AddCountry(new Country(R.drawable.marshall_islands, R.raw.marshall_islands));
//		continent.AddCountry(new Country(R.drawable.kiribati, R.raw.kiribati));
//		continent.AddCountry(new Country(R.drawable.federated_states_of_micronesia, R.raw.federated_states_of_micronesia));
//		continent.AddCountry(new Country(R.drawable.vanuatu, R.raw.vanuatu));
//		continent.AddCountry(new Country(R.drawable.palau, R.raw.palau));
//		continent.AddCountry(new Country(R.drawable.tuvalu, R.raw.tuvalu));
//
//		return continent;
//	}
//
}
