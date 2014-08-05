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
