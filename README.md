GoEvent
=======

projeto de referência para uma arquitetura modular baseada em Java EE e OSGi 

Atualmente o projeto conta com os seguintes bundles OSGi:

<uL>
	<li>goevent: projeto raiz 
		<ul><li>base_view: bundle WAB (web aplication bundle) raiz da aplicação, contendo templates facelets</li></ul>
		<ul>
			<li>event: projeto raiz do módulo de eventos
				<ul>
					<li>event_api: api do módulo, expondo pacotese contendo o modelo e as interfaces de serviço e também registra o Service de PersistenceContext </li>
					<li>event_dao: implementa os serviços regirstrados na event_api</li>
					<li>event_view_fragment: pacote do tipo webFragment, conta com os formulários e ManagedBeans JSF do módulo</li>
				</ul>
			</li>
		</ul>
	</li>
</ul>


Execução
========

Para testar o projeto é necessário utilizar o servidor Glassfish 4, e instalar cada .jar ou .war como um bundle OSGi através do painél visual (localhost:4848), ou copiá-los para a pasta <glassfish>/glassfish/domains/domain1/autodeploy/bundles/

Apache Felix WebConsole
=======================

É recomendável instalar o bundle OSGi <a href="http://felix.apache.org/documentation/subprojects/apache-felix-web-console.html">Felix Webconsole</a> no seu Glassfish, ele permite visualizar os bundles instalados e diversas informações sobre eles, bem como instalar novos bundles.

a forma mais fácil de instalar esse bundle é fazer o download da versão <a href="http://ftp.unicamp.br/pub/apache//felix/org.apache.felix.webconsole-4.2.2-all.jar">all-in-one</a> e copiá-la para a pasta citada acima. 
use usuario e senha: admin
