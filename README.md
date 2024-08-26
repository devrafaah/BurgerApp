<h1>3 - BurgerApp - Android Studio - Kotlin</h1> 
<p>O BurgerApp é um aplicativo focado em oferecer uma experiência única para os amantes de hambúrgueres. Com uma interface amigável e moderna, o aplicativo permite que os usuários explorem, pesquisem e descubram detalhes sobre uma variedade de hambúrgueres. O projeto utiliza uma arquitetura modularizada, que facilita implementações futuras e manutenção do código, garantindo uma experiência fluida e otimizada.</p>

<div class="flex">
  <img src="https://github.com/user-attachments/assets/1b301af8-347d-40de-af7f-17b5f9fb82fd" width="253px"/>
  <img src="https://github.com/user-attachments/assets/7c6f1502-4aca-4b13-8732-2a119fa89706" width="260px"/>
  <img src="https://github.com/user-attachments/assets/086c4e6d-a0dd-469c-811a-faa124464507" width="255px"/>
</div>

<h2>Funcionalidades Principais</h2> 
<p>O aplicativo oferece um conjunto de funcionalidades para os usuários encontrarem e explorarem hambúrgueres de maneira simples e eficiente:</p> 
<ul> 
  <li>Busca por Nome: Permite aos usuários pesquisar hambúrgueres específicos pelo nome, retornando resultados precisos e relevantes.</li> 
  <li>Detalhes do Hambúrguer: Exibe informações detalhadas sobre cada hambúrguer, incluindo ingredientes, preços e locais onde podem ser encontrados.</li> 
  <li>Imagens Otimizadas: Carregamento rápido e eficiente de imagens dos hambúrgueres utilizando a biblioteca Picasso.</li> 
  <li>Experiência de Navegação Intuitiva: Navegação entre diferentes telas e funcionalidades do aplicativo de forma simplificada e intuitiva, utilizando o componente Navigation.</li> 
</ul> 
<h2>Arquitetura do Projeto</h2> 
<p>O BurgerApp segue uma arquitetura modularizada, que separa responsabilidades e facilita a manutenção e expansão do projeto. A estrutura modular inclui:</p> 
<div> 
  <h3>Camada de Apresentação (View)</h3> 
  <p>Responsável por exibir os dados e interagir com o usuário. Utiliza View Binding para simplificar a interação com os componentes da interface do usuário.</p> 
  <h3>Camada de Negócios (ViewModel)</h3> 
  <p>Gerencia os dados exibidos na interface, realizando operações e transformações necessárias antes de repassá-los para a View.</p> 
  <h3>Camada de Dados (Model)</h3> 
  <p>Gerencia a obtenção e manipulação de dados, seja de APIs ou outras fontes de dados. Utiliza Retrofit para chamadas HTTP e manipulação de dados remotos.</p> 
</div> 
<h2>Implementações Utilizadas</h2> 
<p>Abaixo estão listadas as principais bibliotecas e frameworks utilizados no desenvolvimento do BurgerApp:</p> 
<ul> 
  <li><strong>Retrofit</strong>: Framework de cliente HTTP para Android, utilizado para fazer requisições à API "Burgers Hub" e receber dados JSON.</li> 
  <li><strong>Hilt</strong>: Framework de injeção de dependências que simplifica a configuração e o ciclo de vida de instâncias necessárias no projeto.</li> 
  <li><strong>Picasso</strong>: Biblioteca para carregamento e cache de imagens, garantindo uma experiência fluida ao exibir imagens dos hambúrgueres.</li> 
  <li><strong>OkHttp</strong>: Biblioteca para requisições HTTP, utilizada juntamente com Retrofit para gerenciar conexões e adicionar interceptores para logging.</li>
  <li><strong>Navigation</strong>: Facilita a navegação entre diferentes telas do aplicativo, utilizando SafeArgs para passar dados de forma segura entre destinos.</li> 
  <li><strong>LiveData e ViewModel</strong>: Gerenciamento de dados reativos para manter a UI sincronizada com as mudanças nos dados.</li> 
  <li><strong>Kotlin Serialization</strong>: Utilizado para serialização e desserialização de objetos Kotlin, integrando-se facilmente com Retrofit para manipulação de JSON.</li> 
</ul> 
<h2>Configurações e Permissões</h2> 
<p>O aplicativo requer as seguintes permissões e configurações para funcionar corretamente:</p> 
<ul> 
  <li>Permissão para acesso à internet: <code>&lt;uses-permission android:name="android.permission.INTERNET"/&gt;</code></li> 
</ul> 
<h2>Documentação Técnica</h2> 
<p>A seguir está um resumo das principais dependências e frameworks utilizados no projeto:</p> 
<pre>
  
  // Retrofit 
  implementation("com.squareup.retrofit2:retrofit:2.9.0") 
  implementation("com.squareup.retrofit2:converter-gson:2.9.0")
  
  // Hilt 
  implementation("com.google.dagger:hilt-android:2.51.1") 
  kapt("com.google.dagger:hilt-android-compiler:2.51.1")
  
  // Picasso 
  implementation("com.squareup.picasso:picasso:2.71828")
  
  // OkHttp 
  implementation(platform("com.squareup.okhttp3:okhttp-bom:4.12.0")) 
  implementation("com.squareup.okhttp3")
  
  // Navigation 
  implementation("androidx.navigation:navigation-fragment-ktx:2.7.7") 
  implementation("androidx.navigation:navigation-ui-ktx:2.7.7")
  
  // Lifecycle - ViewModel & LiveData 
  implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.4") 
  implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.4")
  
  // Kotlin Serialization 
  implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.1") 
  implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0")
</pre>

<h2>Estrutura de Diretórios</h2> 
<p>A estrutura de diretórios do projeto é organizada de forma a refletir a arquitetura modular e seguir as melhores práticas de desenvolvimento Android:</p> 
<pre> - app/
  - manifests/
  - kotlin+java/
    - com.example.burgersapp/
      - data/
      - di/
      - domain/
      - network/
      - presenter/
      - util/
      - MyApplication
    - com.example.burgersapp (androidTest)/
    - com.example.burgersapp (test)/
  - java (generated)/
  - assets/
  - res/
    - res (generated)/
</pre> 
<h2>Considerações Finais</h2> 
<p>O BurgerApp foi desenvolvido com o objetivo principal de entender o funcionamento de uma API em um ambiente Android. Utilizando Retrofit, OkHttp, Serialization e entre outras funcionalidades. O projeto se concentra na integração de dados dinâmicos através de uma API externa. Embora simples, o projeto proporciona uma base sólida para a compreensão das ferramentas essenciais necessárias para o consumo de APIs em aplicativos móveis.</p>
