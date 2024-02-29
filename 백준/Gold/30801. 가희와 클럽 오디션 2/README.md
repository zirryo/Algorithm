# [Gold V] 가희와 클럽 오디션 2 - 30801 

[문제 링크](https://www.acmicpc.net/problem/30801) 

### 성능 요약

메모리: 14420 KB, 시간: 156 ms

### 분류

구현, 파싱, 문자열

### 제출 일자

2024년 2월 29일 12:27:44

### 문제 설명

<p>가희는 클럽 오디션 모드 중 8키 일반 모드를 플레이하고 있습니다. 이 모드는 여러 레벨의 노트가 나옵니다. 레벨이 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D45B TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>n</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$n$</span></mjx-container>인 키 노트는 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D45B TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>n</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$n$</span></mjx-container>개의 키가 나옵니다. 표시된 순서대로 올바르게 친 후에, 타이밍에 맞게 <code>Space</code> 키를 누르면 판정에 따라 점수를 획득합니다.</p>

<p>키는 2가지 종류 중 하나입니다.</p>

<ul>
	<li>정방향 키
	<ul>
		<li>주어지는 노트와 같은 방향을 의미하는 키를 쳐야 일치한다고 판정합니다.</li>
	</ul>
	</li>
	<li>역방향 키
	<ul>
		<li>주어지는 노트와 반대 방향을 의미하는 키를 쳐야 일치한다고 판정합니다.</li>
	</ul>
	</li>
</ul>

<p style="text-align: center;"><img alt="" src="https://u.acmicpc.net/a180ff40-6114-4820-ab40-3aa03bdb80c0/2%20-%20%EB%B3%B5%EC%82%AC%EB%B3%B8.png"></p>

<p style="text-align: center;"><strong>[그림 1]</strong> 역방향 키가 있는 레벨 6의 키 노트</p>

<p>[그림 1]의 키 노트에서 2번째, 5번째, 6번째 키는 주황색으로 표시되어 있습니다. 이들은 역방향 키를 의미합니다. 군청색으로 표시된 1번째, 3번째, 4번째 키는 정방향 키를 의미합니다. 따라서, 이 키 노트의 방향은 왼쪽에서부터 우, 좌상, 좌하, 우, 좌하, 상이 됩니다. 플레이 하는 유저가 어떤 순서로 키를 쳤는지에 따라, 앞에서부터 몇 개의 키가 일치하는지가 결정됩니다. 즉, 레벨이 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D459 TEX-I"></mjx-c></mjx-mi><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D463 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>l</mi><mi>v</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$lv$</span></mjx-container>인 키 노트가 나왔을 때, 아래와 같은 알고리즘으로 상태가 결정됩니다.</p>

<ul>
	<li>처음 키 노트가 등장하고, 유저가 아무런 키도 입력하지 않았다면 앞에서부터 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mn class="mjx-n"><mjx-c class="mjx-c30"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>0</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$0$</span></mjx-container>개의 키와 일치한 상태입니다.</li>
	<li>앞에서부터 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D456 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>i</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$i$</span></mjx-container>개의 키와 일치한 상태일 때
	<ul>
		<li><mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"> <mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D456 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n" space="4"><mjx-c class="mjx-c3D"></mjx-c></mjx-mo><mjx-mi class="mjx-i" space="4"><mjx-c class="mjx-c1D459 TEX-I"></mjx-c></mjx-mi><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D463 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>i</mi><mo>=</mo><mi>l</mi><mi>v</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$i=lv$</span></mjx-container>인 경우, 임의의 키가 입력되면 <strong>앞에서부터 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mn class="mjx-n"><mjx-c class="mjx-c30"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>0</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$0$</span></mjx-container>개의 키가 일치한 상태</strong>로 전환됩니다.</li>
		<li><mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"> <mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D456 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n" space="4"><mjx-c class="mjx-c2260"></mjx-c></mjx-mo><mjx-mi class="mjx-i" space="4"><mjx-c class="mjx-c1D459 TEX-I"></mjx-c></mjx-mi><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D463 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>i</mi><mo>≠</mo><mi>l</mi><mi>v</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$i \ne lv$</span></mjx-container>인 경우
		<ul>
			<li>유저가 입력한 키와 키 노트의 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D456 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n" space="3"><mjx-c class="mjx-c2B"></mjx-c></mjx-mo><mjx-mn class="mjx-n" space="3"><mjx-c class="mjx-c31"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>i</mi><mo>+</mo><mn>1</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$i+1$</span></mjx-container>번째 키가 일치하다고 판정되면, 앞에서부터 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D456 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n" space="3"><mjx-c class="mjx-c2B"></mjx-c></mjx-mo><mjx-mn class="mjx-n" space="3"><mjx-c class="mjx-c31"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>i</mi><mo>+</mo><mn>1</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$i+1$</span></mjx-container>개의 키와 일치한 상태가 됩니다.</li>
			<li>그렇지 않으면 앞에서부터 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mn class="mjx-n"><mjx-c class="mjx-c30"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>0</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$0$</span></mjx-container>개의 키가 일치한 상태로 전환됩니다.</li>
		</ul>
		</li>
	</ul>
	</li>
</ul>

<p>정방향 키 우, 우하, 좌하, 우, 우상, 하 순서대로 나온 레벨 6의 키 노트가 있습니다. [그림 2]부터 [그림 4]에서 키에 채워진 색깔의 의미는 아래와 같습니다.</p>

<ul>
	<li>노란색
	<ul>
		<li>앞에서부터 일치하는 키</li>
	</ul>
	</li>
	<li>파란색
	<ul>
		<li>남은 키. <strong><mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"> <mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D459 TEX-I"></mjx-c></mjx-mi><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D463 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>l</mi><mi>v</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$lv$</span></mjx-container>개의 키가 일치한 상태로 되기 위해</strong> 순서대로 쳐야 하는 키.</li>
	</ul>
	</li>
</ul>

<p style="text-align: center;"><img alt="" src="https://u.acmicpc.net/9c2cdadc-d23d-431b-9b49-392474a76bf0/3%20-%20%EB%B3%B5%EC%82%AC%EB%B3%B8.png"></p>

<p style="text-align: center;"><strong>[그림 2]</strong> 키 노트의 상태 #1</p>

<p>[그림 2]의 위는 앞에서부터 2개의 키가 일치한 상태를 의미합니다. 이 상태에서 우 키를 입력하면 [그림 2]의 아래와 같은 상태가 됩니다. 키 노트의 3번째 키인 좌하와 입력한 방향 우가 일치하지 않기 때문입니다.</p>

<p style="text-align: center;"><img alt="" src="https://u.acmicpc.net/42590bfa-8eb4-4fb2-aa10-0f24ab1ab69c/4%20-%20%EB%B3%B5%EC%82%AC%EB%B3%B8.png"></p>

<p style="text-align: center;"><strong>[그림 3]</strong> 키 노트의 상태 #2</p>

<p>앞에서부터 2개의 키가 일치한 상태에서 좌하를 의미하는 키를 입력하면, 앞에서부터 3개의 키가 일치하는 상태(그림 3의 아래)가 됩니다. 키 노트의 3번째 키인 좌하와 입력한 방향 좌하가 일치하기 때문입니다.</p>

<p>레벨이 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D459 TEX-I"></mjx-c></mjx-mi><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D463 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>l</mi><mi>v</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$lv$</span></mjx-container>인 키 노트에 대해, 앞에서부터 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D459 TEX-I"></mjx-c></mjx-mi><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D463 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>l</mi><mi>v</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$lv$</span></mjx-container>개의 키와 일치한 상태에서 임의의 키를 입력하면, 앞에서부터 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mn class="mjx-n"><mjx-c class="mjx-c30"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>0</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$0$</span></mjx-container>개의 키와 일치하는 상태로 바뀌게 됩니다. [그림 4]는 이를 보여줍니다.</p>

<p style="text-align: center;"><img alt="" src="https://u.acmicpc.net/fe954fc6-fe57-48fa-a8fc-a565db296f80/5%20-%20%EB%B3%B5%EC%82%AC%EB%B3%B8.png"></p>

<p style="text-align: center;"><strong>[그림 4]</strong> 키 노트의 상태 #3</p>

<p><code>Space</code> 키는 레벨이 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D459 TEX-I"></mjx-c></mjx-mi><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D463 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>l</mi><mi>v</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$lv$</span></mjx-container>인 키 노트에 대해 판정을 받을 때 누르게 됩니다. 최종 판정은 아래와 같습니다.</p>

<ul>
	<li>타이밍에 맞추어서 <code>Space</code> 키를 눌렀을 때

	<ul>
		<li>앞에서부터 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D459 TEX-I"></mjx-c></mjx-mi><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D463 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>l</mi><mi>v</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$lv$</span></mjx-container>개의 키가 일치한 상태이면 성공입니다.</li>
		<li>그렇지 않으면 실패합니다.</li>
	</ul>
	</li>
	<li>타이밍에 맞지 않게 <code>Space</code> 키를 누른 경우 실패합니다.</li>
</ul>

<p>가희가 쳐야 하는 노트가 주어지고, 해당 노트의 타이밍이 올 때까지 가희가 누른 키가 순서대로 주어집니다. 가희가 해당 노트의 타이밍에 맞추어 <code>Space</code> 키를 눌렀을 때, 최종 판정이 성공인지, 실패인지 출력해 주세요.</p>

### 입력 

 <p>1번째 줄에 레벨이 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D459 TEX-I"></mjx-c></mjx-mi><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D463 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>l</mi><mi>v</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$lv$</span></mjx-container>인 노트에 대한 정보가 주어집니다. 노트에 있는 키 노트는 아래와 같이 주어집니다.</p>

<p style="text-align: center;">{<code>direction</code>}{<code>is_reverse</code>}</p>

<ul>
	<li><code>direction</code>

	<ul>
		<li><span style="color:#e74c3c;"><code>W</code></span>, <span style="color:#e74c3c;"><code>A</code></span>, <span style="color:#e74c3c;"><code>S</code></span>, <span style="color:#e74c3c;"><code>D</code></span>, <span style="color:#e74c3c;"><code>LU</code></span>, <span style="color:#e74c3c;"><code>LD</code></span>, <span style="color:#e74c3c;"><code>RU</code></span>, <span style="color:#e74c3c;"><code>RD</code></span> 중 하나로 주어지며, 각각 상, 좌, 하, 우, 좌상, 좌하, 우상, 우하 방향입니다.</li>
	</ul>
	</li>
	<li><code>is_reverse</code> <strong>(optional)</strong>
	<ul>
		<li>역방향 키인 경우 <code>direction</code> 뒤에 문자 <span style="color:#c0392b;"><code>!</code></span>로 주어집니다. 예를 들어, <span style="color:#e74c3c;"><code>W!</code></span>로 주어지면, <span style="color:#e74c3c;"><code>W</code></span>의 반대 방향인 하 방향을 의미합니다.</li>
	</ul>
	</li>
</ul>

<p>2번째 줄에 가희가 입력한 키가 주어집니다. 입력한 키는 <span style="color:#e74c3c;"><code>W</code></span>, <span style="color:#e74c3c;"><code>8</code></span>, <span style="color:#e74c3c;"><code>A</code></span>, <span style="color:#e74c3c;"><code>4</code></span>, <span style="color:#e74c3c;"><code>S</code></span>, <span style="color:#e74c3c;"><code>2</code></span>, <span style="color:#e74c3c;"><code>D</code></span>, <span style="color:#e74c3c;"><code>6</code></span>, <span style="color:#e74c3c;"><code>7</code></span>, <span style="color:#e74c3c;"><code>1</code></span>, <span style="color:#e74c3c;"><code>9</code></span>, <span style="color:#e74c3c;"><code>3</code></span> 중 하나로 주어지며, 각각의 키에 대한 설명은 아래와 같습니다.</p>

<table align="center" border="1" cellpadding="1" cellspacing="1" class="table table-bordered" style="width: 400px;">
	<tbody>
		<tr>
			<td style="text-align: center;">방향</td>
			<td style="text-align: center;">키</td>
		</tr>
		<tr>
			<td style="text-align: center;">상</td>
			<td style="text-align: center;"><span style="color:#e74c3c;"><code>W</code></span> 또는 <span style="color:#e74c3c;"><code>8</code></span></td>
		</tr>
		<tr>
			<td style="text-align: center;">하</td>
			<td style="text-align: center;"><span style="color:#e74c3c;"><code>S</code></span> 또는 <span style="color:#e74c3c;"><code>2</code></span></td>
		</tr>
		<tr>
			<td style="text-align: center;">좌</td>
			<td style="text-align: center;"><span style="color:#e74c3c;"><code>A</code></span> 또는 <span style="color:#e74c3c;"><code>4</code></span></td>
		</tr>
		<tr>
			<td style="text-align: center;">우</td>
			<td style="text-align: center;"><span style="color:#e74c3c;"><code>D</code></span> 또는 <span style="color:#e74c3c;"><code>6</code></span></td>
		</tr>
		<tr>
			<td style="text-align: center;">좌상</td>
			<td style="text-align: center;"><span style="color:#e74c3c;"><code>7</code></span></td>
		</tr>
		<tr>
			<td style="text-align: center;">좌하</td>
			<td style="text-align: center;"><span style="color:#e74c3c;"><code>1</code></span></td>
		</tr>
		<tr>
			<td style="text-align: center;">우상</td>
			<td style="text-align: center;"><span style="color:#e74c3c;"><code>9</code></span></td>
		</tr>
		<tr>
			<td style="text-align: center;">우하</td>
			<td style="text-align: center;"><span style="color:#e74c3c;"><code>3</code></span></td>
		</tr>
	</tbody>
</table>

<p style="text-align: center;"><strong>[표 1]</strong> 유저가 입력한 키와 대응되는 방향</p>

### 출력 

 <p>입력이 주어진 키 노트에 대해 최종 판정이 성공이면 <span style="color:#e74c3c;"><code>Yes</code></span>를, 그렇지 않으면 <span style="color:#e74c3c;"><code>No</code></span>를 출력해 주세요.</p>

